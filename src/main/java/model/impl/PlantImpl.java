package model.impl;

import javafx.util.Pair;
import model.api.Plant;

public class PlantImpl implements Plant{


    private final double damage;
    private final String entityName;
    private final double timeBetweenAttacks;
    private double remainingLife;
    private final Pair<Double,Double> position;
    
    public PlantImpl(double damage, double remainingLife, String entityName, double timeBetweenAttacks, Pair<Double, Double> position){
        this.damage = damage;
        this.remainingLife = remainingLife;
        this.entityName = entityName;
        this.timeBetweenAttacks = timeBetweenAttacks;
        this.position = position;
    }

    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public double getRemainingLife() {
        return remainingLife;
    }

    @Override
    public Pair<Double,Double> getPosition() {
        return position;
    }

    @Override
    public boolean isAlive() {
        if(remainingLife > 0) return true;
        return false;
    }

    @Override
    public String getEntityName() {
       return entityName;
    }

    @Override
    public double getTimeBetweenAttacks() {
        return timeBetweenAttacks;
    }

    @Override
    public void receiveDamage(double damageReceived) {
        remainingLife = remainingLife -damageReceived;
    }

}
