/*
 * RunWoolies.java
 *
 * Version:
 * $Id: RunWoolies.java,v 1.1 2012/05/03 21:56:42 vcss243 Exp csci140 $
 */

/**
 * Test the TrollsBridge and Woolies simulation.
 * Test by creating a bunch of Woolies and let them cross the TrollsBridge.
 * <p>
 * Note: java -enableassertions should cause Woolies to validate their side.
 * </p>
 * @author     Tommy Li
 * @author     Ben Steele
 */
public class RunWoolies {

    /** SIDE_ONE is Merctran.  */
    public final static String SIDE_ONE = "Merctran";

    /** SIDE_TWO is Sicstine.  */
    public final static String SIDE_TWO = "Sicstine";

    /** 
     * Command interface for collecting all the functions in this test suite.
     * Single method is Command.execute().
     */
    private interface Command {
        public void execute();
    }

    /** 
     * testSuite is the list of test cases.
     */
    private static Command[] testSuite = {
        new Command() { public void execute() { RunWoolies.test0(); }},
        new Command() { public void execute() { RunWoolies.test1(); }},
        new Command() { public void execute() { RunWoolies.test2(); }},
        new Command() { public void execute() { RunWoolies.test3(); }},
    };

    /** TEST_COUNT is number of test cases.  */
    public final static int TEST_COUNT = testSuite.length;

    /**
     * test0 is Test Scenario 0, an extremely simple, non-waiting test.
     * test0 provides an example template/pattern for writing a test case.
     */
    static void test0() {

        System.out.println( "Begin test0. ===============================\n" );
        Thread init = Thread.currentThread();      // init spawns the Woolies

        // Create a TrollsBridge of capacity 3.
        TrollsBridge trollBridge = new TrollsBridge( 3 );

        // Set an optional, test delay to stagger the start of each woolie.
        int delay = 1000;

        // Create the Woolies and store them in an array.
        Thread peds[] = {
            new Woolie( "Al",    3, SIDE_ONE, trollBridge ),
            new Woolie( "Bob",   4, SIDE_TWO, trollBridge ),
        };

        for ( int j = 0; j < peds.length; ++j ) {
            // Run them by calling their start() method.
            try {
                peds[j].start();
                init.sleep( delay );
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
                break;
            }
        }
        // Now, the test must give the woolies time to finish their crossings.
        for ( int j = 0; j < peds.length; ++j ) {
            try {
                peds[j].join();
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
                break;
            }
        }
        System.out.println( "\n=============================== End test0." );
        return;

    }

    /**
     * test1 is Test Scenario 1, another fairly simple simulation run.
     * test1 provides another example for writing a test case.
     */
    static void test1() {

        System.out.println( "Begin test1. ===============================\n" );

        Thread init = Thread.currentThread();      // init spawns the Woolies

        // Create a TrollsBridge of capacity 3.
        TrollsBridge trollBridge = new TrollsBridge( 3 );

        int delay = 1000;

        // Create the Woolies and store them in an array.
        Thread peds[] = {
            new Woolie( "Al",    3, SIDE_ONE, trollBridge ),
            new Woolie( "Bob",   2, SIDE_ONE, trollBridge ),
            new Woolie( "Cathy", 2, SIDE_TWO, trollBridge ),
            new Woolie( "Doris", 3, SIDE_TWO, trollBridge ),
            new Woolie( "Edith", 3, SIDE_ONE, trollBridge ),
            new Woolie( "Fred",  2, SIDE_TWO, trollBridge ),
        };

        for ( int j = 0; j < peds.length; ++j ) {
            // Run them by calling their start() method.
            try {
                peds[j].start();
                init.sleep( delay );         // delay start of next woolie
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
            }
        }
        // Now, the test must give the woolies time to finish their crossings.
        for ( int j = 0; j < peds.length; ++j ) {
            try {
                peds[j].join();              // wait for next woolie to finish
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
            }
        }

        System.out.println( "\n=============================== End test1." );
        return;
    }

    /**
     * test2 is Test Scenario 2, a more complex simulation.
     */
    static void test2() {

        System.out.println( "Begin test2. ===============================\n" );

        Thread init = Thread.currentThread();      // init spawns the Woolies

        // Create a TrollsBridge of capacity 3.
        TrollsBridge trollBridge = new TrollsBridge( 3 );

        // Set an optional, test delay to stagger the start of each woolie.
        int delay = 1000;

        // Create the Woolies and store them in an array.
        Thread peds[] = {
            new Woolie( "Abomasnow",   3, SIDE_ONE, trollBridge ),
            new Woolie( "Blastoise",   4, SIDE_TWO, trollBridge ),
            new Woolie( "Charizard",   7, SIDE_ONE, trollBridge ),
            new Woolie( "Diancie",     5, SIDE_TWO, trollBridge ),
            new Woolie( "Elgyem",      2, SIDE_ONE, trollBridge ),
            new Woolie( "Feraligatr",  7, SIDE_TWO, trollBridge ),
            new Woolie( "Gengar",      8, SIDE_ONE, trollBridge ),
            new Woolie( "Heracross",  10, SIDE_TWO, trollBridge ),
            new Woolie( "Igglybuff",   3, SIDE_ONE, trollBridge ),
            new Woolie( "Jumpluff",    4, SIDE_TWO, trollBridge ),
            new Woolie( "Kangaskhan",  9, SIDE_ONE, trollBridge ),
            new Woolie( "Lucario",     7, SIDE_TWO, trollBridge ),
            new Woolie( "Medicham",    6, SIDE_ONE, trollBridge ),
        };

        for ( int j = 0; j < peds.length; ++j ) {
            // Run them by calling their start() method.
            try {
                peds[j].start();
                init.sleep( delay );
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
                break;
            }
        }
        // Now, the test must give the woolies time to finish their crossings.
        for ( int j = 0; j < peds.length; ++j ) {
            try {
                peds[j].join();
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
                break;
            }
        }
        System.out.println( "\n=============================== End test2." );
        return;
    }

   /**
    * Test 3 is an even more complex one, with 26 Woolies.
    */
    static void test3() {

        System.out.println( "Begin test3. ===============================\n" );

        Thread init = Thread.currentThread();      // init spawns the Woolies

                // Create a TrollsBridge of capacity 3.
        TrollsBridge trollBridge = new TrollsBridge( 3 );

        // Set an optional, test delay to stagger the start of each woolie.
        int delay = 1000;

        // Create the Woolies and store them in an array.
        Thread peds[] = {
            new Woolie( "Arceus",    3, SIDE_ONE, trollBridge ),
            new Woolie( "Bulbasaur", 4, SIDE_TWO, trollBridge ),
            new Woolie( "Cresselia", 7, SIDE_ONE, trollBridge),
            new Woolie( "Darkrai",   2, SIDE_TWO, trollBridge),
            new Woolie( "Entei",     7, SIDE_ONE, trollBridge),
            new Woolie( "Ferrothorn",3, SIDE_TWO, trollBridge),
            new Woolie( "Genesect",  2, SIDE_ONE, trollBridge),
            new Woolie( "Heatran",   9, SIDE_TWO, trollBridge),
            new Woolie( "Infernape", 7, SIDE_ONE, trollBridge),
            new Woolie( "Jirachi",  10, SIDE_TWO, trollBridge),
            new Woolie( "Keldeo",    4, SIDE_ONE, trollBridge),
            new Woolie( "Landorus",  7, SIDE_TWO, trollBridge),
            new Woolie( "Mew",       5, SIDE_ONE, trollBridge),
            new Woolie( "Nidoking" , 8, SIDE_TWO, trollBridge),
            new Woolie( "Omanyte",   9, SIDE_ONE, trollBridge),
            new Woolie( "Palkia",    3, SIDE_TWO, trollBridge),
            new Woolie( "Quilava",   4, SIDE_ONE, trollBridge),
            new Woolie( "Regigigas", 6, SIDE_TWO, trollBridge),
            new Woolie( "Shaymin",   7, SIDE_ONE, trollBridge),
            new Woolie( "Terrakion", 8, SIDE_TWO, trollBridge),
            new Woolie( "Uxie",      5, SIDE_ONE, trollBridge),
            new Woolie( "Volcanion", 3, SIDE_TWO, trollBridge),
            new Woolie( "Weavile",   4, SIDE_ONE, trollBridge),
            new Woolie( "Xerneas",   2, SIDE_TWO, trollBridge),
            new Woolie( "Yveltal",   9, SIDE_ONE, trollBridge),
            new Woolie( "Zygarde",   7, SIDE_TWO, trollBridge),
        };

        for ( int j = 0; j < peds.length; ++j ) {
            // Run them by calling their start() method.
            try {
                peds[j].start();
                init.sleep( delay );
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
                break;
            }
        }
        // Now, the test must give the woolies time to finish their crossings.
        for ( int j = 0; j < peds.length; ++j ) {
            try {
                peds[j].join();
            }
            catch ( InterruptedException e ) {
                System.err.println( "Abort. Unexpected thread interruption." );
                break;
            }
        }
        System.out.println( "\n=============================== End test3." );
        return;
    }

    /**
     * Run all the tests in this test suite.
     *
     * @param args not used
     */
    public static void main( String args[] ) {

        for ( int j = 0; j < TEST_COUNT; ++j ) {
            testSuite[j].execute();
        }
    }

}

/* 
 * Revisions:
 * $Log: RunWoolies.java,v $
 * Revision 1.1  2012/05/03 21:56:42  vcss243
 * Initial revision
 *
 */
