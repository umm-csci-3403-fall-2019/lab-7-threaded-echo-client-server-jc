package echoserver;

import java.io.IOException;
import java.lang.Thread;
import java.net.Socket;

public class EchoClient {
	public static final int PORT_NUMBER = 6013;
	public static String server;

	public static void main(String[] args) throws IOException {
//		if (args.length > 0) {
//			server = args[0];
//		} else {
//			server = "127.0.0.1";
//		}
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException {

		Socket socket = new Socket(server, PORT_NUMBER);
		EchoClientThreadIn input = new EchoClientThreadIn(socket);
		EchoClientThreadOut output = new EchoClientThreadOut(socket);
		Thread threader = new Thread(input);
		Thread threader2 = new Thread(output);
		threader.start();
		threader2.start();

	}


}