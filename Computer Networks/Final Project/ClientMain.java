import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientMain { //client class
	static Client client;	//connecting client
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String serverAddress=null; //server address to which client is connecting
		if(args.length==0) {
			System.out.print("Enter the server address: ");
			serverAddress=br.readLine();
		} else {
			serverAddress=args[0]; //fetches first argument from array which is server address
		}
		String nickname; //username of client
		do {
			System.out.print("Enter your temporary username: ");
			nickname=br.readLine();
			try {
				client=new Client(nickname, serverAddress); //creating object of class Client
				if(client!=null)
					break;
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}while(true);
		Runtime.getRuntime().addShutdownHook(new ShutdownHook());
		client.start();
	}
	
	private static class ShutdownHook extends Thread {
		@Override
		public void run() {
			client.shutdown();
		}
	}
}
