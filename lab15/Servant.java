/**
 * Servant.java
 *
 * This class holds the file transfer aspect to the server.
 *
 * File:
 *	$Id: Servant.java,v 1.0 2015/12/03 12:12:31 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: Servant.java,v $
 *	Initial revision
 *
 */

/**
 * The Servant class.
 *
 * @author Tommy Li
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.lang.Thread;
import java.lang.Runnable;

public class Servant extends Thread implements Runnable {

    /**
     * The socket being connected to.
     */
    private Socket socket;

    /**
     * The INetAddress of the socket.
     */
    private InetAddress inetAddress;

    /**
     * The port number this socket is associated with.
     */
    private int portNumber;

    /**
     * The host name of the client.
     */
    private String hostName;

    /**
     * Constuctor sets up the Servant class.
     * @param socket - The socket being connected to.
     */
    public Servant(Socket socket) {
        this.socket = socket;
        inetAddress = socket.getInetAddress();
        portNumber = socket.getPort();
        hostName = inetAddress.getHostName();
    }

    /**
     * The run method of the Servant.
     */
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Name of file?");

            String input = " "; 
            while (!input.equals("")) {
                input = in.readLine();
		break;
	    }
            BufferedReader fileReader;
            try {
                fileReader = new BufferedReader(new FileReader(input));
                while (true) {
                    String line = fileReader.readLine();
	            if (line == null) {
                        System.out.println("Transfer completed.");
                        socket.close();
                        fileReader.close();
                        return;
		    }
                    out.println(line);
	        }
	    } catch (FileNotFoundException e) {
                out.println("File not found.");
                socket.close();
                return;
	    }
	} catch (IOException e) {}
    }
}
