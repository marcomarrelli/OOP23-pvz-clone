package model.impl;

import java.util.Objects;

/*
 * A standard generic Pair<E1,E2>, with getters, hashCode, equals, and toString well implemented. 
 */

public class Pair<E1,E2> {
	
	private final E1 e1;
	private final E2 e2;
	
	public Pair(E1 x, E2 y) {
		super();
		this.e1 = x;
		this.e2 = y;
	}

	public E1 getX() {
		return e1;
	}

	public E2 getY() {
		return e2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(e1, e2);
	}

	@Override
	public boolean equals(Object obj) {
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
		return "Pair [e1=" + e1 + ", e2=" + e2 + "]";
	}
	
	

}

