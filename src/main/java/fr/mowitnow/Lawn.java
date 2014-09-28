package fr.mowitnow;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Lawn class : the lawn is backed by a rectangle starting from (0,0) to (width,height)
 * Created by guillaume on 25/09/2014.
 */
public class Lawn {

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lawn lawn = (Lawn) o;

        if (height != lawn.height) return false;
        if (width != lawn.width) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = width;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
