/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





public final class Constants {
	public final class Server {
		public final static int PORT=12325;
		public final static String LIST_HEADER="list";
		public final static long CLIENT_EXPIRE_TIME=5000;	//5000 milliseconds
		public final static long CLIENT_CHECK_RATE=1000;	//1000 milliseconds
		//command for exiting
		public final static String EXIT_COMMAND="exit";
		public final static String EXIT_COMMAND_1="Exit";
		public final static String EXIT_COMMAND_2="EXIT";
	}
	public final class Client {
		public final static long HEARTBEAT_RATE=1000;	//1000 milliseconds
		public final static long CHAT_REQUEST_TIMEOUT=10000;
		public final static long LIST_REQUEST_TIMER=1000;
		
		public final static int MAX_MSG_SIZE=400;
		
		
		
		public final static String LIST_COMMAND="l";
		public final static String CONNECT_COMMAND="c";
		public final static String DISCONNECT_COMMAND="bye";
		public final static String MESSAGE_COMMAND="m";
		public final static String HELP_COMMAND="help";
		public final static String EXIT_COMMAND="exit";
		public final static String EXIT_COMMAND_1="Exit";
		public final static String EXIT_COMMAND_2="EXIT";
		
		
		public final static String CHAT_REQUEST="crq";
		public final static String CHAT_ACCEPT="acc";
		public final static String CHAT_DENY="den";
		public final static String CHAT_DISCONNECT="fin";
		public final static String CHAT_TYPING="typ";
		
		public final static String HELP_TEXT="\nType '"+LIST_COMMAND+"' to get the list of online clients.\n" +
				"Type '"+CONNECT_COMMAND+" <client_name>' to connect to a client.\n" +
				"Type '"+MESSAGE_COMMAND+"' to send a message to the connected client.\n" +
				"Type '"+DISCONNECT_COMMAND+"' to disconnect from the connected client.\n" +
				"Type '"+HELP_COMMAND+"' to display this message.\n" +
				"Type '"+EXIT_COMMAND+","+EXIT_COMMAND_1+","+EXIT_COMMAND_2+"' to exit.\n";
	}
	public final static String HEARTBEAT_ID="hb";
	public final static String REQUEST_ID="rq";
	
	public final static String DUPLICATE_NICKNAME = "Duplicate";
	public final static String ACCEPTED_NICKNAME = "Nickname accepted";
}
