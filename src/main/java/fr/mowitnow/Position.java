package fr.mowitnow;

/**
 * Point class
 * Created by guillaume on 25/09/2014.
 */
public class Position {

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return x != position.x ? false : y == position.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
