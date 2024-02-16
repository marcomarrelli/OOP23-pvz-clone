package pvzclone.model.impl;

import java.util.Objects;

/**
 * A standard generic Pair&lt;X,Y&gt;.
 * It comprehends getters, hashCode, equals, and toString.
 * 
 * @param <X> first element type.
 * @param <Y> second element type.
 */
public final class Pair<X, Y> {
    private final X x;
    private final Y y;

    /**
     * Pair Constructor.
     * 
     * @param x first element.
     * @param y second element.
     */
    public Pair(final X x, final Y y) {
        super();
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the first element of the Pair Object.
     * 
     * @return first element of pair.
     */
    public X getX() {
        return this.x;
    }

    /**
     * Returns the second element of the Pair Object.
     * 
     * @return second element of pair.
     */
    public Y getY() {
        return this.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        return Objects.equals(this.x, other.x) && Objects.equals(this.y, other.y);
    }

    @Override
    public String toString() {
        return "Pair [X = " + this.x + ", Y = " + this.y + "]";
    }
}
