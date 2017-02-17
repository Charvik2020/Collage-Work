import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class Client {
	
	/**
	 * Client side sockets
	 */
	DatagramSocket serverSocket, clientSocket;
	
	/**
	 * Server's IP Address
	 */
	InetAddress serverIP;
	
	/**
	 * Username of the client
	 */
	String nickname;
	
	/**
	 * Timer to send heartbeat at regular intervals
	 */
	Timer heartbeatTimer;
	
	Timer chatRequestTimeout, listRequestTimer;
	
	/**
	 * Object to get input from user
	 */
	BufferedReader br;
	
	Thread serverReceiver, clientReceiver, msgQueueManager;
	
	HashMap<String, ClientDetails> otherClients; //to store name of client and its details and is efficent than arrays in searching
	
	/**
	 * Will be set to true if the client is waiting for the list from the server.
	 * It is set as volatile because its value will be changed by different threads
	 */
	volatile boolean waitForList;
	
	/**
	 * Identifies if there is currently an active chat session or not
	 */
	volatile boolean currentlyChatting;
	
	volatile boolean terminalLock;
	
	volatile boolean pendingChatRequest, pendingChatAccept;
	
	volatile boolean nicknameAccepted;
	
	volatile String pendingChatRequestPartner;
	
	volatile ClientDetails currentChatPartner, pendingAcceptClient;
	
	Queue<String> msgQueue;
	
	/**
	 * Initializes the client with the given nickname
	 * @param nn nickname
	 */
	public Client(String nn, String serverAddress) {
		if(!nn.matches("[A-Za-z0-9]+"))
			throw new IllegalArgumentException("Invalid username. A username can only contain letters and numbers.");
		nickname=nn;
		try {
			serverSocket=new DatagramSocket();	//try to bind the port. Note this is required as it will be needed for if any other client wants to send a message
			clientSocket=new DatagramSocket();
		} catch (SocketException e) {
			System.err.println("Error binding any port");
			System.exit(-1);
		}
		try {
			serverIP=InetAddress.getByName(serverAddress);
		} catch (UnknownHostException e) {
			System.out.println("Unknown server");
			System.exit(-1);
		}
		br=new BufferedReader(new InputStreamReader(System.in));
		otherClients=null;
		heartbeatTimer=new Timer();	//initialize Timer object
		chatRequestTimeout=new Timer();
		listRequestTimer=new Timer();
		currentlyChatting=false;	//initially not chatting with anyone
		currentChatPartner=null;
		msgQueue=new LinkedList<String>();
	}
	
	/**
	 * Starts all the threads for the client
	 */
	public void start() {
		serverReceiver=new Thread(new ServerReceiver());
		serverReceiver.start();
		clientReceiver=new Thread(new ClientReceiver());
		clientReceiver.start();
		msgQueueManager=new Thread(new MsgQueueManager());
		msgQueueManager.start();
		
		nicknameAccepted=false;
		
		//send a single heartbeat
		sendThroughSocket(Constants.HEARTBEAT_ID+" "+clientSocket.getLocalPort()+" "+nickname, serverSocket, serverIP, Constants.Server.PORT);
		
		while(!nicknameAccepted);	//wait till nickname is accepted
		
		promptLoop();
	}
	
	/**
	 * Loop for the terminal prompt
	 */
	private void promptLoop() {
		String command;
		while(true) {
			try {
				command=br.readLine();
			} catch (IOException e) {
				System.err.println("Error reading command");
				if(pendingChatAccept) {
					sendThroughSocket(Constants.Client.CHAT_DENY, clientSocket, pendingAcceptClient.getIP(), pendingAcceptClient.getPort());	//deny the request
					pendingChatAccept=false;
					pendingAcceptClient=null;
				}
				continue;
			}
			
			if(pendingChatAccept) {
				char c=command.charAt(0);
				if(c=='y') {
					System.out.println("\nRequest Accepted. Type 'm' to send a message.");
					sendThroughSocket(Constants.Client.CHAT_ACCEPT, clientSocket, pendingAcceptClient.getIP(), pendingAcceptClient.getPort());	//accept the request
					currentChatPartner=pendingAcceptClient;
					currentlyChatting=true;
					pendingChatAccept=false;
					pendingAcceptClient=null;
					msgQueue.clear();	//clear message queue
				} else {
					System.out.println("\nRequest Denied.");
					sendThroughSocket(Constants.Client.CHAT_DENY, clientSocket, pendingAcceptClient.getIP(), pendingAcceptClient.getPort());	//deny the request
					pendingChatAccept=false;
					pendingAcceptClient=null;
				}
			} else if(command.equals(Constants.Client.LIST_COMMAND)) {
				requestForList();
			}
			else if(command.equals(Constants.Client.CONNECT_COMMAND) || command.startsWith(Constants.Client.CONNECT_COMMAND+" ")) {
				if(otherClients==null) {
					System.out.println("\nPlease type '"+Constants.Client.LIST_COMMAND+"' first to get the list of online clients.");
					continue;
				}
				if(isCurrentlyChatting()) {
					System.out.println("\nYou are already connected to someone. Please disconnect first. Type '"+Constants.Client.DISCONNECT_COMMAND+"'");
					continue;
				}
				int spaceIndex=command.indexOf(' ');
				String name;
				if(spaceIndex==-1) {	//if name is not given with the command 
					System.out.print("\nWhom do you want to chat with? ");
					try {
						name=br.readLine();
					} catch (IOException e) {
						continue;
					}
				} else
					name=command.substring(spaceIndex+1);
				
				//checking if the name exists in the client list
				if(otherClients.containsKey(name))
					connectToClient(name);
				else
					System.err.println("\nInvalid client name, try again!!! Type '"+Constants.Client.LIST_COMMAND+"' to get the list of online clients");
			} else if(command.equals(Constants.Client.MESSAGE_COMMAND)) {
				if(!isCurrentlyChatting()) {	//if not chatting with anyone currently
					System.out.println("\nNot chatting with anyone currently. Please connect to someone first.");
					continue;
				}
				String msg; 
				lockTerminal();
				sendThroughSocket(Constants.Client.CHAT_TYPING, clientSocket, currentChatPartner.getIP(), currentChatPartner.getPort());
				System.out.println("Type in the message you want to send:");
				try {
					msg=br.readLine();
				} catch (IOException e) {
					releaseTerminal();
					continue;
				}
				if(msg.trim().length()==0)
					System.out.println("Please enter some message. Type '"+Constants.Client.MESSAGE_COMMAND+"' to send a message.");
				else {
					int l=msg.length(), i=0;
					while(i<l) {
						int x=(l-i)<Constants.Client.MAX_MSG_SIZE?(l-i):Constants.Client.MAX_MSG_SIZE;
						sendMessageToChatPartner(msg.substring(i, i+x));
						i+=x;
					}
				}
				releaseTerminal();
			} else if(command.equals(Constants.Client.DISCONNECT_COMMAND)) {
				if(!isCurrentlyChatting()) {	//if not chatting with anyone currently
					System.out.println("\nNot chatting with anyone currently. Please connect to someone first.");
					continue;
				}
				disconnectFromClient();
			} else if(command.equals(Constants.Client.HELP_COMMAND)) {
				System.out.println(Constants.Client.HELP_TEXT);
			} else if(command.equals(Constants.Client.EXIT_COMMAND)||command.equals(Constants.Client.EXIT_COMMAND_1)||command.equals(Constants.Client.EXIT_COMMAND_2)) {
				System.out.println("\nExiting.");
				shutdown();
				System.exit(0);
			} else {
				System.out.println("\nInvalid command. Type '"+Constants.Client.HELP_COMMAND+"' for help text.");
			}
		}
	}
	
	private void lockTerminal() {
		terminalLock=true;
	}
	
	private void releaseTerminal() {
		terminalLock=false;
	}
	
	private boolean terminalIsLocked() {
		return terminalLock;
	}
	
	private void connectToClient(String name) {
		ClientDetails cd=otherClients.get(name);
		if(cd==null)
			return;
		sendThroughSocket(Constants.Client.CHAT_REQUEST+" "+nickname, clientSocket, cd.getIP(), cd.getPort());	//send chat request
		pendingChatRequestPartner=name;
		pendingChatRequest=true;
		System.out.println("\nTrying to connect to "+name);
		chatRequestTimeout.schedule(new ChatRequestTimeout(), Constants.Client.CHAT_REQUEST_TIMEOUT);
	}
	
	private void disconnectFromClient() {
		if(currentChatPartner==null)
			return;
		sendThroughSocket(Constants.Client.CHAT_DISCONNECT, clientSocket, currentChatPartner.getIP(), currentChatPartner.getPort());	//send disconnect request
		currentChatPartner=null;
		currentlyChatting=false;

	}
	
	private void sendMessageToChatPartner(String msg) {
		if(currentChatPartner==null)
			return;
		sendThroughSocket(Constants.Client.MESSAGE_COMMAND+" "+msg, clientSocket, currentChatPartner.getIP(), currentChatPartner.getPort());	//send message
		System.out.println("\nMessage Sent: "+msg);
	}
	
	public boolean isCurrentlyChatting() {
		return currentlyChatting;
	}
	
	/**
	 * Sends a request to the server to get the list of currently online clients
	 */
	private void requestForList() {
		waitForList=true;
		sendThroughSocket(Constants.REQUEST_ID, serverSocket, serverIP, Constants.Server.PORT);
		listRequestTimer.schedule(new ListRequestTimer(), Constants.Client.LIST_REQUEST_TIMER);
		while(waitForList);
	}
	
	public boolean sendThroughSocket(String msg, DatagramSocket socket, InetAddress ip, int port) {
		byte[] data=msg.getBytes();
		try {
			socket.send(new DatagramPacket(data, data.length, ip, port));	//send the heartbeat
		} catch (IOException e) {
			System.err.println("\nUnable to send message");
			return false;
		}
		return true;
	}
	
	private boolean verifyClient(InetAddress ip, ClientDetails cd) {
		if(cd==null || ip==null)
			return false;
		return ip.equals(cd.getIP());
	}
	
	/**
	 * Class send a single heartbeat to the server
	 */
	private class HeartbeatTask extends TimerTask {
		
		@Override
		public void run() {
			sendThroughSocket(Constants.HEARTBEAT_ID+" "+clientSocket.getLocalPort()+" "+nickname, serverSocket, serverIP, Constants.Server.PORT);	//heartbeat data comprises of its nickname
		}
	}
	
	private class ServerReceiver implements Runnable {

		@Override
		public void run() {
			while(true) {
				byte[] data=new byte[1024*1024];
				DatagramPacket packet=new DatagramPacket(data, data.length);
				try {
					serverSocket.receive(packet);
				} catch(IOException e) {
					System.err.println("Error while receiving message from server");
					continue;
				}
				String[] reply=new String(data).split("\n");
				if(reply[0].equals(Constants.Server.LIST_HEADER)) {
					otherClients=new HashMap<String, ClientDetails>();
					for(int i=1;i<reply.length;i++) {
						String[] line=reply[i].split(":");
						if(line.length<3) continue;
						String name=line[0].trim();
						if(name.equals(nickname)) continue;	//skip self
						InetAddress ip;
						try {
							String ipAddr=line[1].trim();
							if(ipAddr.equals("127.0.0.1"))
								ip=serverIP;
							else
								ip=InetAddress.getByName(line[1].trim());
						} catch (UnknownHostException e) {
							continue;
						}
						int port=Integer.parseInt(line[2].trim());
						otherClients.put(name, new ClientDetails(name, ip, port));
					}
				} else if(reply[0].equals(Constants.DUPLICATE_NICKNAME)) {
					System.out.println(reply[1]);
					String nn = "$";	//just something
					while(true)
					{
						System.out.print("Enter another nick name: ");
						try {
							nn = br.readLine();
						} catch(Exception e) {
							System.out.println("Error reading input from the console.");
						}
						if(!nn.matches("[A-Za-z0-9]+"))
							System.err.println("Invalid nickname. A nickname can only contain letters and numbers.");
						else {
							nickname = nn;
							break;
						}
					}
					
					//try this name again
					sendThroughSocket(Constants.HEARTBEAT_ID+" "+clientSocket.getLocalPort()+" "+nickname, serverSocket, serverIP, Constants.Server.PORT);
				}
				else if(reply[0].trim().equals(Constants.ACCEPTED_NICKNAME)){
					System.out.println("\nConnection established. Type 'help' to get help text.");
					heartbeatTimer.scheduleAtFixedRate(new HeartbeatTask(), 0, Constants.Client.HEARTBEAT_RATE);
					nicknameAccepted=true;
				}
			}
		}
	}
	
	private class ClientReceiver implements Runnable {

		@Override
		public void run() {
			while(true) {
				byte[] data=new byte[1024*1024];
				DatagramPacket packet=new DatagramPacket(data, data.length);
				try {
					clientSocket.receive(packet);
				} catch(IOException e) {
					System.err.println("Error while receiving message from server");
					continue;
				}
				String reply=(new String(data)).trim();
				if(reply.startsWith(Constants.Client.CHAT_REQUEST)) {
					if(isCurrentlyChatting()) {	//if already chatting with someone right now
						sendThroughSocket(Constants.Client.CHAT_DENY, clientSocket, packet.getAddress(), packet.getPort());	//deny the request
					} else {
						String[] parts=reply.split(" ", 2);
						if(parts.length<2) {	//if name is not present
							sendThroughSocket(Constants.Client.CHAT_DENY, clientSocket, packet.getAddress(), packet.getPort());	//deny the request
							continue;
						}
						System.out.println("\nUser '"+parts[1]+"' wants to chat with you. Accept(y/n)?");
						pendingAcceptClient=new ClientDetails(parts[1], packet.getAddress(), packet.getPort());
						pendingChatAccept=true;
					}
				} else if(reply.equals(Constants.Client.CHAT_ACCEPT)) {
					if(!pendingChatRequest)	//ignore if no pending chat request
						continue;
					if(!verifyClient(packet.getAddress(), otherClients.get(pendingChatRequestPartner)))
						continue;
					currentChatPartner=otherClients.get(pendingChatRequestPartner);
					System.out.println("\nRequest accepted by "+pendingChatRequestPartner);
					msgQueue.clear();	//clear message queue
					currentlyChatting=true;
					pendingChatRequest=false;
					pendingChatRequestPartner=null;
				} else if(reply.equals(Constants.Client.CHAT_DENY)) {
					if(pendingChatAccept) {
						pendingChatAccept=false;
						pendingAcceptClient=null;
						System.out.println("\nRequest timed out.");
					}
					if(!pendingChatRequest)	//ignore if no pending chat request
						continue;
					if(!verifyClient(packet.getAddress(), otherClients.get(pendingChatRequestPartner)))
						continue;
					System.out.println("\nRequest denied by "+pendingChatRequestPartner);
					pendingChatRequest=false;
					pendingChatRequestPartner=null;
				} else if(reply.startsWith(Constants.Client.MESSAGE_COMMAND+" ")) {
					if(!isCurrentlyChatting())
						continue;	//discard if not currently chatting with anyone
					String[] parts=reply.split(" ", 2);
					if(parts.length<2)	//if invalid
						continue;
					if(!verifyClient(packet.getAddress(), currentChatPartner))	//if wrong sender
						continue;
					msgQueue.add(parts[1].trim());
				} else if(reply.equals(Constants.Client.CHAT_DISCONNECT)) {
					if(!isCurrentlyChatting())
						continue;	//ignore if not chatting currently
					if(!verifyClient(packet.getAddress(), currentChatPartner))
						continue;
					System.out.println("\nDisconnected from "+currentChatPartner.getName());
					currentChatPartner=null;
					currentlyChatting=false;
				} else if(reply.equals(Constants.Client.CHAT_TYPING)) {
					if(!isCurrentlyChatting())
						continue;	//ignore if not chatting currently
					if(!verifyClient(packet.getAddress(), currentChatPartner))
						continue;
					if(!terminalIsLocked())
						System.out.println(currentChatPartner.getName()+" is typing...");
				}
			}
		}
	}
	
	private class ChatRequestTimeout extends TimerTask {

		@Override
		public void run() {
			if(!pendingChatRequest)
				return;
			ClientDetails cd=otherClients.get(pendingChatRequestPartner);
			sendThroughSocket(Constants.Client.CHAT_DENY, clientSocket, cd.getIP(), cd.getPort());	//deny the request
			pendingChatRequest=false;
			pendingChatRequestPartner=null;
			System.out.println("Request timed out");
		}
		
	}
	
	private class ListRequestTimer extends TimerTask {

		@Override
		public void run() {
			Iterator<String> it=otherClients.keySet().iterator();
			if(!it.hasNext()) {
				System.out.println("\n###Sorry no other clients are online.");
				waitForList=false;
				return;
			}
			System.out.println("\n###The following other clients are online:");
			while(it.hasNext()) {
				System.out.println("##\t"+it.next());
			}
			waitForList=false;
		}
		
	}
	
	private class MsgQueueManager implements Runnable {

		@Override
		public void run() {
			while(true) {
				while(terminalIsLocked() || msgQueue.isEmpty());	//wait till terminal lock is released or any msg arrives
				String msg=msgQueue.poll();
				
				/*
				 * Checking if msg is null.
				 * This case may happen due to many threads using the same queue.
				 * Note that, in the currently implementation, only this thread is
				 * polling from the queue, so such an error may not occur.
				 */
				if(msg==null)
					continue;
				
				System.out.println("\n"+currentChatPartner.getName()+" says: "+msg);
			}
		}
	}
	
	public void shutdown() {
		if(isCurrentlyChatting()) {
			disconnectFromClient();
		}
		if(pendingChatAccept) {
			sendThroughSocket(Constants.Client.CHAT_DENY, clientSocket, pendingAcceptClient.getIP(), pendingAcceptClient.getPort());	//deny the request
		}
	}
}
