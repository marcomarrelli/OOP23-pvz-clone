package model.impl;

import java.util.Objects;

/**
 * A standard generic Pair<E1,E2>, with getters, hashCode, equals, and toString
 * well implemented.
 * 
 * @param <E1> first element type.
 * @param <E2> second element type.
 */
public final class Pair<E1, E2> {

	private final E1 e1;
	private final E2 e2;

	/**
	 * Pair Constructor.
	 * 
	 * @param x first element.
	 * @param y second element.
	 */
	public Pair(final E1 x, final E2 y) {
		super();
		this.e1 = x;
		this.e2 = y;
	}

	/**
	 * Returns the first element of the Pair Object.
	 * 
	 * @return first element of pair.
	 */
	public E1 getX() {
		return e1;
	}

	/**
	 * Returns the second element of the Pair Object.
	 * 
	 * @return second element of pair.
	 */
	public E2 getY() {
		return e2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(e1, e2);
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
		Pair other = (Pair) obj;
		return Objects.equals(e1, other.e1) && Objects.equals(e2, other.e2);
	}

	@Override
	public String toString() {
		return "Pair [e1 = " + e1 + ", e2 = " + e2 + "]";
	}
}
