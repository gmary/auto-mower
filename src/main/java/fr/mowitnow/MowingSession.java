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
     * @param lawn the lawn to mow
     */
    public MowingSession(Lawn lawn) {
        this.lawn = lawn;
    }

    /**
     * Add a new mower to the mowing session with the specified position
     * @param initialPosition initial position
     * @return the mower added to the session
     */
    public Mower addMower(Location initialPosition) {
        return new Mower(lawn, initialPosition);
    }
}
