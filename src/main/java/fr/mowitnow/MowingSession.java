package fr.mowitnow;

/**
 * Mowing session class
 * Created by guillaume on 28/09/2014.
 */
public class MowingSession {


    /**
     * Current lawn
     */
    private final Lawn lawn;

    /**
     * Mowing session constructor
     *
     * @param lawnDef the lawn definition to mow
     */
    public MowingSession(String lawnDef) {
        this.lawn = Lawn.valueOf(lawnDef);
    }

    /**
     * Add a new mower to the mowing session with the specified position
     *
     * @param initLocation initial location
     * @return the mower added on the lawn
     */
    public Mower addMower(String initLocation) {
        return new Mower(lawn, Location.valueOf(initLocation));
    }
}
