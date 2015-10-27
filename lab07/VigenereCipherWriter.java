/**
 * VigenereCipherWriter.java
 *
 * This class holds the writer for the Vignere cipher.
 *
 * File:
 *	$Id: VigenereCipherWriter.java,v 1.0 2015/10/16 21:01:44 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: VigenereCipherWriter.java,v $
 *	Initial revision
 *
 */

/**
 * A Vigenere cipher writerr in java.
 *
 * @author Tommy Li
 */

import java.io.Writer;
import java.lang.Character;

public class VigenereCipherWriter extends java.io.Writer {

    /**
     * Holds the writer for the cipher.
     */
    private java.io.Writer wr;

    /**
     * Holds the keyword for the cipher.
     */
    private java.lang.String keyword;

    /**
     * The position of the keyword to encode.
     */
    private int pos;


    /**
     * Creates a new Vigenere cipher writer.
     * @param rd        The underlying writer.
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
    public VigenereCipherWriter(java.io.Writer wr, java.lang.String keyword) throws java.lang.IllegalArgumentException {
        if (!keyword.matches("[a-zA-Z]+")) {
            throw new java.lang.IllegalArgumentException("All letters in keyword must be between A-Z or a-z.");
	}
        this.wr = wr;
        this.keyword = keyword;
        pos = 0;
    }

    /**
     * Enciphers the character represented by the int.
     * @param ci     The int to be enciphered.
     * @return       The enciphered int.
     */
    public int encipher(int ci) {
        char key = keyword.charAt(pos);
        boolean isUpper = Character.isUpperCase((char)ci);
        ci = (int)Character.toLowerCase((char)ci);
        if (ci >= 'a' && ci <= 'z') {
            ci = ((ci + key - 2 * 'a') % 26) + 'a';
	}
        pos++;
        pos = pos%keyword.length();
        if (isUpper) {
            ci = (int)Character.toUpperCase((char)ci);
	}
        return ci;
    }

    /**
     * Writes a single character. Encodes a single character and writes it 
     * to the underlying Writer.
     * @param ci             int specifying a character to be written.
     * @throws IOException   Thrown when an IO error occurs.
     * @override             write() in java.io.Writer.
     */
    public void write(int ci) throws java.io.IOException {
        wr.write(encipher(ci));
    }

    /**
     * Writes a portion of an array of characters. Encodes a portion of 
     * an array and writes the encoded portion to the underlying OutputStream.
     * @param cbuf           Array of characters
     * @param off            Offset at which to begin writing characters.
     * @param len            Max number of characters to write.
     * @throws IOException   Thrown when IO error occurs.
     * @ovveride             write() in class java.io.Writer.
     */
    public void write(char[] cbuf, int off, int len) throws java.io.IOException {
        for (int i = 0; i < len; i++) {
            write(cbuf[i + off]);
	}
    }

    /**
     * Flushes the stream.
     * @throws IOException   Thrown when an IO error occurs.
     * @override             flush() in java.io.Writer.
     */
    public void flush() throws java.io.IOException {
        wr.flush();
    }

    /**
     * Closes the stream, flushing it first.
     * @throws IOException   Thrown when an IO error occurs.
     * @override             close() in java.io.Writer.
     */
    public void close() throws java.io.IOException {
        flush();
        wr.close();
    }


}
