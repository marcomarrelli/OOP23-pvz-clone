package model.impl;

import model.impl.Pair;
import model.api.Plant;

public class PlantImpl implements Plant{


    private final double damage;
    private final String entityName;
    private final double timeBetweenAttacks;
    private double remainingLife;
    private final Pair<Double,Double> position;
    
    public PlantImpl(final double damage, final double remainingLife, final String entityName, final double timeBetweenAttacks, final Pair<Double, Double> position){
        this.damage = damage;
        this.remainingLife = remainingLife;
        this.entityName = entityName;
        this.timeBetweenAttacks = timeBetweenAttacks;
        this.position = position;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public double getRemainingLife() {
        return this.remainingLife;
    }

    @Override
    public Pair<Double,Double> getPosition() {
        return this.position;
    }

    @Override
    public boolean isAlive() {
        if(remainingLife > 0) return true;
        return false;
    }

    @Override
    public String getEntityName() {
       return this.entityName;
    }

    @Override
    public double getTimeBetweenAttacks() {
        return this.timeBetweenAttacks;
    }

    @Override
    public void receiveDamage(double damageReceived) {
        remainingLife = remainingLife - damageReceived;
    }

}
