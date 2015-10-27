/*
 * UnderflowException.java
 * 
 * Version: 
 *     $Id: UnderflowException.java,v 1.2 2001/05/09 17:08:01 cs2 Exp $
 * 
 * Revisions: 
 *     $Log: UnderflowException.java,v $
 *     Revision 1.2  2001/05/09 17:08:01  cs2
 *     Forgot to change the name of the constructor.
 *
 *     Revision 1.1  2001/05/09 15:26:44  cs2
 *     Initial revision
 *
 */

/**
 * An Exception to be used with the Queue hierarchy.
 * 
 * @author Hank Etlinger
 * @author Lois Rixner
 */

public class UnderflowException  extends Exception {

    /**
     * The constructor for this exception
     *
     * @param message the detailed message associated with this exception.
     */

    public UnderflowException( String message ) {
        super( message );
    }

} // UnderflowException
