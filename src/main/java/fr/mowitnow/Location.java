package fr.mowitnow;

import java.util.Objects;

import static java.util.Objects.hash;

/**
 * Location class which represent a position plus a direction.
 * Created by guillaume on 28/09/2014.
 */
public class Location {

    /**
     * Location pattern
     */
    private static final String LOCATION_PATTERN = "[1-9]?[0-9]* [1-9]?[0-9]* [N|E|W|S]{1}";

    /**
     * Position
     */
    private final Position position;

    /**
     * Direction
     */
    private final Direction direction;

    /**
     * Location constructor
     *
     * @param position  postion
     * @param direction direction
     */
    public Location(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    /**
     * Get a new instance of Location based on the location param
     * @param location location definition
     * @return a new location, throw NullPointerException when the location is null and IllegalArgumentException when location mismatch the pattern
     */
    public static Location valueOf(String location) {
        Objects.requireNonNull(location, "The location shouldn't be null");
        if (!location.matches(LOCATION_PATTERN)) {
            throw new IllegalArgumentException("The location should follow this pattern " + LOCATION_PATTERN);
        }
        final int lastWithspaceIndex = location.lastIndexOf(" ");
        final String position = location.substring(0, lastWithspaceIndex);
        final String direction = location.substring(lastWithspaceIndex + 1);
        return new Location(Position.valueOf(position), Direction.valueOf(direction));
    }

    /**
     * Get the postion
     *
     * @return position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Get the direction
     *
     * @return direction
     */
    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Location p = (Location) o;
        return Objects.equals(position, p.position) && Objects.equals(direction, p.direction);
    }

    @Override
    public int hashCode() {
        return hash(position, direction);
    }

    @Override
    public String toString() {
        return position + " " + direction;
    }
}
