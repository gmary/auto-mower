package fr.mowitnow;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.hash;

/**
 * Lawn class : the lawn is backed by a rectangle starting from (0,0) to (width,height)
 * Created by guillaume on 25/09/2014.
 */
public class Lawn {

    /**
     * Lawn def pattern
     */
    private static final String LAWN_PATTERN = "[1-9]?[0-9]* [1-9]?[0-9]*";

    /**
     * Lawn's width
     */
    private final int width;

    /**
     * Lawn's height
     */
    private final int height;

    /**
     * Lawn constructor
     *
     * @param width  width
     * @param height height
     */
    public Lawn(int width, int height) {
        checkArgument(width > 0, "The lawn width should be greater than 0");
        checkArgument(height > 0, "The lawn height should be greater than 0");
        this.width = width;
        this.height = height;
    }

    /**
     * Return a new lawn based on the lawn definition : LAWN_PATTERN
     *
     * @param lawn the lawn
     * @return a new lawn initialized with the definition, throw NullPointerException when the lawn is null and IllegalArgumentException when lawn mismatch the pattern
     */
    public static Lawn valueOf(String lawn) {
        Objects.requireNonNull(lawn, "The lawn definition shouldn't be null");
        if (!lawn.matches(LAWN_PATTERN)) {
            throw new IllegalArgumentException("The lawn definition should follow this pattern " + LAWN_PATTERN);
        }
        final String[] lawnParams = lawn.split(" ");
        return new Lawn(Integer.parseInt(lawnParams[0]), Integer.parseInt(lawnParams[1]));
    }

    /**
     * Get the bottom left corner point
     *
     * @return bottom left corner point
     */
    public Position getBottomLeftCorner() {
        return new Position(0, 0);
    }

    /**
     * Get the top right corner point
     *
     * @return top right corner point
     */
    public Position getTopRightCorner() {
        return new Position(width, height);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Lawn p = (Lawn) o;
        return Objects.equals(width, p.width) && Objects.equals(height, p.height);
    }

    @Override
    public int hashCode() {
        return hash(width, height);
    }

    @Override
    public String toString() {
        return width + " " + height;
    }

    /**
     * Check if the position is on the lawn
     *
     * @param position position to check
     * @return true if the position is on the lawn
     */
    public boolean isValidPosition(Position position) {
        final int x = position.getX();
        final int y = position.getY();
        return (x >= 0 && x <= width) && (y >= 0 && y <= height);
    }
}
