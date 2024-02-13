package model.impl;

import java.util.Set;
import java.util.HashSet;

import model.api.Entities;
import model.api.EntitiesFactory;
/* NOTA: creare un metodo che restituisce la posizione dello Zombie. X max larghezza, Y casuale (tra 5/6 pos possibili) */
public class ZombiesFactory implements EntitiesFactory {

    private static final double ATK = 20.0;
    private static final double MAX_LIFE = 100.0;
    private static final int ZOMBIE_SPPED = 2; /*metri al secondo */
    private static final int COOLDOWN = 10;
    
    @Override
    public Entities createEntity() {
        return new ZombieImpl(ATK, COOLDOWN, ZOMBIE_SPPED, MAX_LIFE, new Pair<Integer, Integer>(800, 250));
    }

    @Override
    public Set<Entities> createEntities(int n) {
        Set<Entities> zombieSet = new HashSet<>();
        for (int i=0; i<n; i++){
            zombieSet.add(createEntity());
        }
        return zombieSet;
    }
    
}
