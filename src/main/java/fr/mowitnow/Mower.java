package fr.mowitnow;

/**
 * Mower class
 * Created by guillaume on 28/09/2014.
 */
public class Mower {

    /**
     * Mower location on the lawn
     */
    private final Location location;

    /**
     * Mower constructor
     * @param location  mower location on the lawn
     */
    public Mower(Location location) {
        this.location = location;
    }

    /**
     * Get the current location
     * @return mower location on the lawn
     */
    public Location getLocation() {
        return location;
    }
}
