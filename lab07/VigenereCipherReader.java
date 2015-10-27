/**
 * VigenereCipherReader.java
 *
 * This class holds the reader for the Vignere cipher.
 *
 * File:
 *	$Id: VigenereCipherReader.java,v 1.0 2015/10/16 20:20:12 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: VigenereCipherReader.java,v $
 *	Initial revision
 *
 */

/**
 * A Vigenere cipher reader in java.
 *
 * @author Tommy Li
 */

import java.io.Reader;
import java.lang.Character;
import java.util.Arrays;

public class VigenereCipherReader extends java.io.Reader {

    /**
     * Holds the reader for the cipher.
     */
    private java.io.Reader rd;

    /**
     * Holds the keyword for the cipher.
     */
    private java.lang.String keyword;

    /**
     * The position of the keyword to decode.
     */
    private int pos;

    /**
     * Checks if the stream reaches the end to make
     * sure all characters make it to the end of the stream.
     * This will pass into the read function so the stream is not
     * cut off early.
     */
    private boolean firstread = true;

    /**
     * Creates a new Vigenere cipher reader.
     * @param rd        The underlying reader.
     * @param keyword   The Vigenere cipher keyword. Although the 
     *                  keyword may include both lowercase and uppercase 
     *                  Roman alphabetic characters, the keyword is used 
     *                  in a case-insensitive manner. That is, both the 
     *                  character 'c' and the character 'C' in the keyword
     *                  induce a rotation of 3.
     * @throw           Thrown if keyword is a string that is empty or is 
     *                  not exclusively comprised of characters in the range 
     *                  'a' through 'z' and 'A' through 'Z'.
     */
    public VigenereCipherReader(java.io.Reader rd, java.lang.String keyword) throws java.lang.IllegalArgumentException {
        if (!keyword.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("All letters in keyword must be between A-Z or a-z.");
	}
        this.rd = rd;
        this.keyword = keyword.toLowerCase();
        pos = 0;
    }


    /**
     * Deciphers the character represented by the int.
     * @param ci     The int to be deciphered.
     * @return       The deciphered int.
     */
    public int decipher(int ci) {
        char key = keyword.charAt(pos);
        boolean isUpper = Character.isUpperCase((char)ci);
        ci = (int)Character.toLowerCase((char)ci);
        if (ci >= 'a' && ci <= 'z') {
            ci = (((ci - key + 26) % 26) + 'a');
	}
        pos++;
        pos = pos%keyword.length();
        if (isUpper) {
            ci = (int)Character.toUpperCase((char)ci);
	}
        return ci;
    }

    /**
     * Reads a single character. Reads a single character from the 
     * underlying Reader, decodes it, and returns it.
     * @return                 The ASCII value of the character.
     * @throws IOException     Thrown when an IO error occurs.
     * @override               read() in class java.io.Reader.
     *
     *
     */
    public int read() throws java.io.IOException {
        int r = rd.read();
        if (r == -1) {
            return -1;
	} else {
            return decipher(r);
	}
    }

    /**
     * Reads characters into a portion of an array. Reads characters from 
     * the underlying Reader into a portion of an array and decodes the read 
     * portion.
     * @param cbuf           The destination buffer.
     * @param off            Offset at which to begin storing characters.
     * @param len            Max number of characters to read.
     * @return               The number of characters read, or -1 if the 
     *                       end of the stream was reached.
     * @throws IOException   Thrown when IO error occurs.
     * @override             read() in class java.io.Reader.
     */
    public int read(char[] cbuf, int off, int len) throws java.io.IOException {
        int i;
        for (i = 0; i < len; i++) {
            int r = read();
            if (r == -1 && firstread) {
		firstread = false;
	        return i;
	    } else if (r == -1 && firstread == false) {
		return -1;
	    }
            cbuf[i + off] = (char)r;
	}
        return i;
    }

    /**
     * Skips characters.
     * @param n             The number of characters to skip.
     * @return              The number of characters skipped.
     * @throws IOException  Thrown when an IO error occurs.
     * @override            skip() in class java.io.Reader.
     */
    public long skip(long n) throws java.io.IOException {
        return rd.skip(n);
    }
    /**
     * Tells whether this stream is ready to be read.
     * @return              True is read() does not block for input, false
     *                      otherwise.
     * @throws IOException  Thrown when IO error occurs.
     * @override            ready() in java.io.Reader.
     */
    public boolean ready() throws java.io.IOException {
        return rd.ready();
    }

    /**
     * Tells whether this stream supports the mark() operation.
     * @return              True if the stream supports mark().
     * @throws IOEXception  Thrown when an IO error occurs.
     * @override            markSupported() in class java.io.Reader.
     */
    public boolean markSupported() {
        return rd.markSupported();
    }

    /**
     * Marks the present position in the stream.
     * @param readAheadLimit    Limit on the number of characters that 
     *                          may be read while still preserving the 
     *                          mark. After reading this many characters,
     *                          attempting to reset the stream may fail.
     * @throws IOException      Thrown when an IO error occurs.
     * @override                mark() in class java.io.Reader.
     */
    public void mark(int readAheadLimit) throws java.io.IOException {
        rd.mark(readAheadLimit);
    }

    /**
     * Resets the stream.
     * @throws IOException       Thrown when IO error occurs.
     * @override                 reset() in class java.io.Reader.
     */
    public void reset() throws java.io.IOException {
        rd.reset();
    }

    /**
     * Closes the stream.
     * @throws IOException       Thrown when IO error occurs.
     * @override                 close() in java.io.Reader.
     */
    public void close() throws java.io.IOException {
        rd.close();
    }

}
