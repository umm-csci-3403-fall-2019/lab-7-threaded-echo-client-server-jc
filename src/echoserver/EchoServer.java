package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer implements Runnable{
	
	// REPLACE WITH PORT PROVIDED BY THE INSTRUCTOR
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException, InterruptedException {
		EchoServer server = new EchoServer();
		server.start();
	}

	public void run() {}

	private void start() throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
		final ExecutorService pool;
		pool = Executors.newFixedThreadPool(1);
		while (true) {
			Socket socket = serverSocket.accept();
			OutputStream writer = socket.getOutputStream();
			InputStream input = socket.getInputStream();
			Thread threader = new Thread(new EchoClientThreadOut(input, writer, socket));
			threader.start();

			// Put your code here.
			// This should do very little, essentially:
			//   * Construct an instance of your runnable class
			//   * Construct a Thread with your runnable
			//      * Or use a thread pool
			//   * Start that thread
		}
	}
}