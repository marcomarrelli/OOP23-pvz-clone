package model.impl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.api.Entities;
import model.api.EntitiesFactory;

public class SunsFactory implements EntitiesFactory {
    private final double screenWidth;
    private final double screenHeight;
    private final static double SPEED_Y_AXIS= 1.0;
    private Random random;


    public SunsFactory(final double screenWidth, final double screenHeight) {
        this.screenWidth= screenWidth;
        this.screenHeight= screenHeight;
        this.random= new Random();
    }

    @Override
    public Entities createEntity() {
        return new SunImpl(new Pair<Double, Double>(random.nextDouble(this.screenWidth), -10.0), SPEED_Y_AXIS);
    }

    @Override
    public Set<Entities> createEntities(int n) {
        Set<Entities> sunsSet = new HashSet<>();
        for (int i=0; i<n; i++){
            sunsSet.add(createEntity());
        }
        return sunsSet;
    }
    
}
