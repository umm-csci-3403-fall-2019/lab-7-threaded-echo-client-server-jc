package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoClientThreadOut implements Runnable{
    private final InputStream input;
    private final OutputStream output;
    private final Socket socket;

    public EchoClientThreadOut(InputStream input, OutputStream output, Socket socket){
        this.input = input;
        this.output = output;
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
        // Start listening on the specified port
        ServerSocket sock = new ServerSocket(portNumber);

        // Run forever, which is common for server style services
        while (true) {
            // Wait until someone connects, thereby requesting a date
            Socket client = sock.accept();
            System.out.println("Got a request!");

            int myBytes;
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            while ((myBytes = input.read()) != -1){
                output.write(myBytes);
            }

            // Close the client socket since we're done.
            client.close();
        }
        // *Very* minimal error handling.
    } catch (IOException ioe) {
        System.out.println("We caught an unexpected exception");
        System.err.println(ioe);
    }
    }
}