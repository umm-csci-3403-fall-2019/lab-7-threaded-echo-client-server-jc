package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient implements Runnable{
	public static final int PORT_NUMBER = 6013;
	public static String server;

	public static void main(String[] args) throws IOException {
		if (args.length > 0) {
			server = args[0];
		} else {
			server = "127.0.0.1";
		}
		EchoClient client = new EchoClient();
		client.start();
	}

	public void run(){}

	private void start() throws IOException {

		Socket socket = new Socket(server, PORT_NUMBER);
		OutputStream writer = socket.getOutputStream();
		InputStream input = socket.getInputStream();
		Thread threader = new Thread(new EchoClientThreadIn(System.in, writer, socket));
		threader.start();


	}


}