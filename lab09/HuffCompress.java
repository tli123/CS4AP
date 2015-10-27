/*
 * HuffCompress.java
 *
 * Version:
 *    $Id: HuffCompress.java,v 1.1 2013/10/08 16:00:54 csci140 Exp $
 *
 * Revisions:
 *    $Log: HuffCompress.java,v $
 *    Revision 1.1  2013/10/08 16:00:54  csci140
 *    Initial revision
 *
 *    Revision 1.5  2001/05/07 18:13:37  cs2
 *    Fixed to 20001 style standards
 *
 *    Revision 1.4  2001/02/05 16:23:31  cs2
 *    Removed initial blank line in opening comment.
 *
 *    Revision 1.3  2001/02/03 22:12:59  cs2
 *    Removed javadoc second * on file comment
 *
 *    Revision 1.2  2001/01/29 23:39:21  cs2
 *    kaa changed header, added main comment
 *
 *
 */

import java.io.*;

/**
 * This program will compress a file using Huffman encoding.
 *
 * @author     Paul Tymann
 */

import java.io.*;

public class HuffCompress {

    /*
     * This is the main method. It reads a file, builds a frequency
     * table, and writes the encoded file back out.
     *
     * @param     args    command line arguments, two file names
     *
     */ 
    public static void main( String args[] ) {
	// Usage check

	if ( args.length != 2 ) {
	    System.err.println( "Usage:  java HuffCompress in-file out-file" );
	    System.exit( 1 );
	}

	// Open the input file

	BufferedReader in = null;

	try {
	    in = new BufferedReader( new FileReader( args[0] ) );
	}
	catch ( FileNotFoundException e ) {
	    System.err.println( "HuffCompress:  unable to open " + args[ 0 ] );
	    System.exit( 1 );
	}

	try {

	    // Build the frequency table

	    FrequencyTable freq = new FrequencyTable();
	    int ch;

	    while ( ( ch = in.read() ) != -1 ) {
		freq.add( ( char )ch );
            }

	    // Reset the file back to the beginning

	    in.close();
	    in = new BufferedReader( new FileReader( args[ 0 ] ) );

	    // Now write the file using a HuffmanWriter
	    
	    HuffmanWriter out = new HuffmanWriter( 
                    new FileOutputStream( args[ 1 ] ), freq );

	    while ( ( ch = in.read() ) != -1 ) {
		out.write( ( char ) ch );
            }

	    // Close the streams

	    in.close();
	    out.close();
	}
	catch ( FileNotFoundException e ) {
	    System.err.println( "HuffCompress:  unable to open " + args[ 1 ] );
	    System.exit( 1 );
	}
	catch ( IOException e ) {
	    System.err.println( "HuffCompress:  I/O error" );
	    System.exit( 1 );
	}
    }

} // HuffCompress
