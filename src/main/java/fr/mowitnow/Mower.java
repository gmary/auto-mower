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
     * Lawn
     */
    private final Lawn lawn;

    /**
     * Mower constructor
     *
     * @param location mower location on the lawn
     */
    public Mower(final Lawn lawn, final Location location) {
        this.location = location;
        this.lawn = lawn;
    }

    /**
     * Get the current location
     *
     * @return mower location on the lawn
     */
    public Location getLocation() {
        return location;
    }

    public Mower move(final String orders) {
        //no more order we return the mower
        if ("".equals(orders)) {
            return this;
        }

        String firstOrder = orders.substring(0, 1);
        String otherOrders = orders.substring(1, orders.length());

        if ("G".equals(firstOrder)) {
            return moveLeft().move(otherOrders);
        } else if ("D".equals(firstOrder)) {
            return moveRight().move(otherOrders);
        } else if ("A".equals(firstOrder)) {
            return moveForward().move(otherOrders);
        } else {
            throw new IllegalArgumentException("The order {} is forbidden !!! Change your orders");
        }
    }

    private Mower moveRight() {
        return new Mower(lawn, new Location(location.getPosition(), location.getDirection().turnRight()));
    }

    private Mower moveForward() {
        Location newLocation = null;

        switch (location.getDirection()) {
            case N:
                newLocation = new Location(new Position(location.getPosition().getX(), location.getPosition().getY() + 1), location.getDirection());
                break;
            case W:
                newLocation = new Location(new Position(location.getPosition().getX() - 1, location.getPosition().getY()), location.getDirection());
                break;
            case E:
                newLocation = new Location(new Position(location.getPosition().getX() + 1, location.getPosition().getY()), location.getDirection());
                break;
            case S:
                newLocation = new Location(new Position(location.getPosition().getX(), location.getPosition().getY() - 1), location.getDirection());
                break;
        }
        if (isStillOnLawn(newLocation)) {
            return new Mower(lawn, newLocation);
        }
        return this;
    }

    private boolean isStillOnLawn(Location location) {
        return lawn.isValidPosition(location.getPosition());
    }

    private Mower moveLeft() {
        return new Mower(lawn, new Location(location.getPosition(), location.getDirection().turnLeft()));
    }
}
