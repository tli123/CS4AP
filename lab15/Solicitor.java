/**
 * Solicitor.java
 *
 * This class holds the file transfer spect to the server.
 *
 * File:
 *	$Id: Solicitor.java,v 1.0 2015/12/03 12:32:28 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: Solicitor.java,v $
 *	Initial revision
 *
 */

/**
 * The Solicitor class.
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
import java.util.Scanner;

public class Solicitor {

    /**
     * The InetAdress of the client.
     */
    private InetAddress inetAddress;

    /**
     * The socket of the client.
     */
    private Socket socket;

    /**
     * The scanner that will read the filename.
     */
    private Scanner sc;

    /**
     * Constuctor that sets up the socket for the client, and runs
     * the client.
     * @param Server_name - the name of the server.
     * @param Server_port - the port the server is connected to.
     */
    public Solicitor(String Server_name, int Server_port) {
        inetAddress = InetAddress.getByName(Server_name);
        socket = new Socket(inetAdress, Server_port);

        BufferedReader in = new BufferedReader(new InputStream(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        System.out.println(in.nextLine());

        sc = new Scanner(System.in);
        String filename = null;
        while(sc.hasNextLine()) {
            filename = sc.nextLine();
	}

        out.println(filename);
        
        while (true) {
            String line = in.nextLine();
            if (line != null) {
                System.out.println(line);
	    } else {
                socket.close();
                return;
	    }
 	}
    }

    /**
     * The main method.
     * @param args - Command line arguments.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Solicitor Server_name Server_port");
	}
        Solicitor solicitor = new Solicitor(args[0], Integer.parseInt(args[1]));
    }

}
