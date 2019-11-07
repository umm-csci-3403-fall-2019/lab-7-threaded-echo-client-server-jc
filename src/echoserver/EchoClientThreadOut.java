package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoClientThreadOut implements Runnable{
    private final Socket socket;

    public EchoClientThreadOut(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {

            InputStream input = socket.getInputStream();
            int singleByte;

            while ((singleByte = input.read()) != -1) {
                //input.write(singleByte);
                //output.flush();
                System.out.write(singleByte);
//                System.out.flush();
            }
            System.out.flush();
            socket.shutdownOutput();
        }
        // *Very* minimal error handling.
      catch (IOException ioe) {
        System.out.println("We caught an unexpected exception");
        System.err.println(ioe);
    }
    }
}