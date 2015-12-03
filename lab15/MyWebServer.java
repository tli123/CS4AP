/**
 * MyWebServer.java
 *
 * This class holds the web server.
 *
 * File:
 *	$Id: MyWebServer.java,v 1.0 2015/12/03 12:13:31 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: MyWebServer.java,v $
 *	Initial revision
 *
 */

/**
 * The web server class.
 *
 * @author Tommy Li
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class MyWebServer {

    /**
     * The constuctor that runs the web server.
     */
    public MyWebServer() {

        ServerSocket socket;

        try {
            socket = new ServerSocket(0);
	} catch (IOException e) {
            System.err.print("Error: " + e.getMessage());
            return;
	}

        System.out.println("The server is listening on Port " + socket.getLocalPort() + ".");

        while (true) {
            try {
                Socket connected = socket.accept();
                Servant servant = new Servant(connected);
                System.out.println(connected.toString());
                servant.run();
	    } catch (IOException e) {
                System.err.print("Error: " + e.getMessage());
                return;
	    }
	}
    }

    /**
     * The main method that starts the server.
     * @param args - Command line arguments -- not used.
     */
    public static void main(String[] args) {
        MyWebServer server = new MyWebServer();
    }

}
