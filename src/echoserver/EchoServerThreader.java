package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoServerThreader implements Runnable{
    private final Socket socket;

    public EchoServerThreader(Socket socket){
        this.socket = socket;
    }


    public void run() {
        try {
                InputStream input = socket.getInputStream();
                int read;
                OutputStream output = socket.getOutputStream();
                while((read = input.read()) != -1){
                    output.write(read);
                }
                output.flush();
                output.close();
                input.close();


        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }

    }
}
