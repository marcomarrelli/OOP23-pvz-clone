package input.api;

import model.impl.Pair;

/**
 * The ViewEventListener interface defines a contract for objects that listen to
 * mouse events in a view.
 * Classes implementing this interface can receive notifications about mouse
 * events such as clicks, moves, etc.
 */
public interface ViewEventListener {

    /**
     * Notifies the listener about a mouse event at the specified position.
     *
     * @param pos the position where the mouse event occurred, represented as a Pair
     *            of integers (x, y).
     */
    void notifyMouseEvent(Pair<Integer, Integer> pos);
}
