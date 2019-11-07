package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class EchoClientThreadIn implements Runnable{
    private final Socket socket;

    public EchoClientThreadIn(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {

            OutputStream output = socket.getOutputStream();
            int singleByte;

            while ((singleByte = System.in.read()) != -1) {
                output.write(singleByte);
            }
            output.flush();

            // Close the socket when we're done reading from it
            socket.shutdownOutput();

            // Provide some minimal error handling.
        } catch (ConnectException ce) {
            System.out.println("We were unable to connect to the server");
            System.out.println("You should make sure the server is running.");
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}
