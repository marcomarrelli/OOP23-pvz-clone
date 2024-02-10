package input.api;

import model.impl.Pair;

public interface ViewEventListener {

    void notifyMouseEvent(Pair<Double, Double> pos);

}
