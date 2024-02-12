package input.api;

import model.impl.Pair;

public interface ViewEventListener {

    void notifyMouseEvent(Pair<Integer, Integer> pos);

}
