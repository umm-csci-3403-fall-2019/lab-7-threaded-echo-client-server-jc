package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class EchoClientThreadIn implements Runnable{
    private final InputStream input;
    private final OutputStream output;
    private final Socket socket;

    public EchoClientThreadIn(InputStream input, OutputStream output, Socket socket){
        this.input = input;
        this.output = output;
        this.socket = socket;
    }

    @Override
    public void run(){
        try {

            int singleByte;

            while ((singleByte = System.in.read()) != -1) {
                output.write(singleByte);
                output.flush();
                System.out.write(input.read());
                System.out.flush();
            }

            // Close the socket when we're done reading from it
            socket.close();

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
