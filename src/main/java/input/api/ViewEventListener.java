package input.api;

import javafx.util.Pair;

public interface ViewEventListener {

    void notifyMouseEvent(Pair<Double, Double> pos);

}
