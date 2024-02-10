package model.impl;

import javafx.util.Pair;
import model.api.Game;
import java.util.List;
import java.util.ArrayList;


public class GameImpl implements Game{

    private static final int DELTA=1;

    private List<PlantImpl> plants = new ArrayList<>();
    private List<ZombieImpl> zombies = new ArrayList<>();

    @Override
    public boolean isOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOver'");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void createWave() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createWave'");
    }

    @Override
    public void createPlant(Pair<Double, Double> position) {
        plants.add(new PlantImpl(20, 100, "base plant", 2, position));
    }

    public void mouseEvent(Pair<Double, Double> posClick){
        //qua il model guarda dove è stato fatto il click e di conseguenza gestisce l'evento
        //se è stato fatto su un sole o sulla pianta o il secondo click della pianta
    }

    public void checkCollision(){
        //questo è un metodo che controlla che non ci siano collisioni
        //tipo uno zombie che arriva ad una pianta
        //uno zombie che arriva alla casa
        //il proiettile che colpisce lo zombie
    }
    
}
