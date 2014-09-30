package fr.mowitnow;

import java.util.Objects;

import static java.util.Objects.hash;

/**
 * Position class
 * Created by guillaume on 25/09/2014.
 */
public class Position {

    /**
     * Position pattern
     */
    private static final String POSITION_PATTERN = "[1-9]?[0-9]* [1-9]?[0-9]*";

    /**
     * Coordinate
     */
    private final int x;

    /**
     * Axis
     */
    private final int y;

    /**
     * Point constructor
     *
     * @param x coordinate
     * @param y axis
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the position based on the pattern : [1-9]?[0-9]* [1-9]?[0-9]*
     * @param position position
     * @return new position, throw NullPointerException when the position is null and IllegalArgumentException when position mismatch the pattern
     */
    public static Position valueOf(String position) {
        Objects.requireNonNull(position, "The position shouldn't be null");
        if (!position.matches(POSITION_PATTERN)) {
            throw new IllegalArgumentException("The position should follow this pattern " + POSITION_PATTERN);
        }
        final String[] positionParams = position.split(" ");
        return new Position(Integer.parseInt(positionParams[0]), Integer.parseInt(positionParams[1]));

    }

    /**
     * Get the coordinate value
     *
     * @return coordinate value
     */
    public int getX() {
        return x;
    }

    /**
     * Return the axis value
     *
     * @return axis value
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Position p = (Position) o;
        return Objects.equals(x, p.x) && Objects.equals(y, p.y);
    }

    @Override
    public int hashCode() {
        return hash(x, y);
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
