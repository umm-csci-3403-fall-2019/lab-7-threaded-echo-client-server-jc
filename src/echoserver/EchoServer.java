package echoserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

	
	// REPLACE WITH PORT PROVIDED BY THE INSTRUCTOR
	public static final int PORT_NUMBER = 6013;
	public static void main(String[] args) throws IOException, InterruptedException {
		EchoServer server = new EchoServer();
		server.start();
	}

	private void start() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
		//final ExecutorService pool;
		//pool = Executors.newFixedThreadPool(20);
		while (true) {
			Socket socket = serverSocket.accept();
			EchoServerThreader server = new EchoServerThreader(socket);
			Thread threader = new Thread(server);
			threader.start();
		}
	}

}