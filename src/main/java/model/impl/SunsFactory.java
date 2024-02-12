package model.impl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.api.Entities;
import model.api.EntitiesFactory;

/**
 * This class contains methods to create Sun entities.
 * 
 * @author Sofia Caberletti
 */
public class SunsFactory implements EntitiesFactory {
    private final int screenWidth;
    private final int screenHeight;
    private final static int SPEED_Y_AXIS = 1;
    private Random random;


    public SunsFactory(final int screenWidth, final int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.random= new Random();
    }

    @Override
    public Entities createEntity() {
        return new SunImpl(new Pair<Integer, Integer>(random.nextInt(this.screenWidth), -10), SPEED_Y_AXIS);
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
