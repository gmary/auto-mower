package fr.mowitnow;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum which represent the cardinal points.
 * Created by guillaume on 29/09/2014.
 */
public enum Direction {

    /**
     * North
     */
    N(1),

    /**
     * West
     */
    W(2),

    /**
     * South
     */
    S(3),

    /**
     * East
     */
    E(4);

    /**
     * Direction map by order
     */
    private static Map<Integer, Direction> map = new HashMap<Integer, Direction>();

    /**
     * Inititate the order map
     */
    static {
        for (Direction direction : Direction.values()) {
            map.put(direction.order, direction);
        }
    }

    /**
     * Direction's order
     */
    private final int order;

    /**
     * Enum constructor
     *
     * @param order direction order
     */
    private Direction(final int order) {
        this.order = order;
    }

    /**
     * Turn the current direction to the next on left
     *
     * @return the new direction
     */
    public Direction turnLeft() {
        return map.get(this.order + 1 > 4 ? 1 : this.order + 1);
    }

    /**
     * Turn the current direction to the next on right
     *
     * @return the new direction
     */
    public Direction turnRight() {
        return map.get(this.order - 1 < 1 ? 4 : this.order - 1);
    }
}
