/**
 * Servant.java
 *
 * This class holds the file transfer spect to the server.
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
    private InetAddrss inetAddress;

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
        inetAddress = socket.getINetAddress();
        portNumber = socket.getPort();
        hostName = inetaddress.getHostName();
    }

    /**
     * The run method of the Servant.
     */
    public void run() {
        BufferedReader in = new BufferedReader(new InputStream(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Name of file?");

        String input = in.readLine();
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader(input));
            while (true) {
                String line = fileReader.readLine();
                out.println(line);
	        if (line == null) {
                    System.out.println("Transfer completed.");
                    socket.close();
                    fileReader.close();
                    return;
		}
	    }
	} catch (FileNotFoundException e) {
            out.println("File not found.");
            socket.close();
            return;
	}
    }
}
