/**
 * TankFarm.java
 *
 * A tank farm is a collection of tanks each having a different capacity.  
 * The number of tanks and size of each one are provided as parameters to the
 * tank farm constructor.  Tanks are maintained in the array tanks.  The id
 * for a tank corresponds to the array index for the tank.
 *
 * File:
 *	$Id: TankFarm.java,v 1.0 2015/09/25 16:23:12 csci140 Exp csci140 $
 *
 * Revisions:
 *	$Log: TankFarm.java,v $
 *	Initial revision
 *
 */

/**
 * A TankFarm program in Java.
 *
 * @author Tommy Li
 */

import java.lang.*;

public class TankFarm {
    private Tank[] tanks;  // the actual tank farm
    
    /**
     * Create a tank farm with the specified number of tanks having
     * the capacities specified in the cap parameter.
     *
     * @param howMany The number of tanks in tank farm
     * might not match the size of the array.
     * The farm uses only those needed by the array of capacities.
     * 
     * @param cap     Array of capacities for each tank in tank farm
     *
     * @exception TankFarmException Thrown if the number of tanks in the
     *                              tank farm (i.e., the parameter howMany)
     *                              is less than 1.
     *                              Exception message field is:
     *                              "TankFarm constructor received 0 or 
     *                              negative count."
     * @exception TankCreateException Thrown by the Tank constructor if an
     *                                invalid capacity is requested for a 
     *                                tank.  If the TankFarm receives this 
     *                                exception for any single tank,
     *                                the constructor will print the
     *                                exception message field to stderr and 
     *                                rethrow the exception.
     */

    public TankFarm( int howMany, int cap[] ) throws TankFarmException, TankCreateException {
        if (howMany < 1) {
            throw new TankFarmException("Tankfarm contructor received 0 or negative count");
	}

	// Allocate the actual array of tanks.

	tanks = new Tank[ howMany ];

	// Initialize the tank array with new tanks.
	
	for ( int i = 0; i < howMany; i++ ) {
            try {
                tanks[ i ] = new Tank( i, cap[ i ] );
      	} catch (TankCreateException e) {
                System.err.print(e + "\n");
                throw e;
	    }
	}
            
		
    }

    /**
     * Request to add material to a tank in the tank farm.
     * <p>
     * The operation of adding material to the specified tank is performed by
     * the tank farm object.  TankWarningExceptions are handled by printing
     * the exception message to stderr. Other exceptions are allowed to pass up
     * the call stack.
     *
     * @param id Tank id for the tank in which new material will be added
     * @param in Number of units of material to add to tank
     *
     * @exception TankOverflowException Passed up the call stack if thrown
     *            by Tank object.
     */

    public void addMaterial( int id, int in ) throws TankOverflowException {
        try {
	    tanks[ id ].fill( in );
	} catch (TankWarningException s) {
            System.err.print(s + "\n");
	} catch (TankOverflowException e) {
            throw e;
	}
       
    }
    
    /**
     * Request to remove material from a tank in the tank farm.
     * <p>
     * The operation of removing material from the specified tank is performed 
     * by the tank farm object.  TankWarningExceptions are handled by printing
     * the exception message to stderr.
     *
     * @param id Tank id for the tank from which material will be removed
     * @param out Number of units of material to remove from the tank
     */

    public void removeMaterial( int id, int out ) {
        try {
            tanks[ id ].empty( out );
	} catch (TankWarningException e) {
            System.err.print(e + "\n");
	}
    }

    /**
     * Accessor function for tank level.
     *
     * @param id Id of the tank whose level will be returned.  No check is
     *           made that the parameter is valid.
     *
     * @return returns the current level of the tank.
     */

    public int getTankLevel( int id ) {
	return tanks[ id ].getCurrent();
    }

    /**
     * Accessor function for tank state.
     *
     * @param id Id of the tank whose state will be returned.  No check is
     *           made that the parameter is valid.
     *
     * @return returns the current state of the tank.
     */

    public int getTankState( int id ) {
	return tanks[ id ].getState();
    }

					  
} // TankFarm
