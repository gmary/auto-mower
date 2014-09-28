package fr.mowitnow;

/**
 * Location class which represent a position plus a direction.
 * Created by guillaume on 28/09/2014.
 */
public class Location {

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (direction != location.direction) return false;
        if (!position.equals(location.position)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = position.hashCode();
        result = 31 * result + direction.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "position=" + position +
                ", direction=" + direction +
                '}';
    }
}
