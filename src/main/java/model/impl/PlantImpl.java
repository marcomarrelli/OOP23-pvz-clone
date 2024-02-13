package model.impl;

import model.api.Plant;

/**
 * class that implements Plant interface
 * 
 * @author Zanchini Margherita
 */

public class PlantImpl implements Plant{

    private final double damage;
    private final String entityName;
    private final double timeBetweenAttacks;
    private final Pair<Integer, Integer> position;
    private final long cooldown;

    private double remainingLife;
    private long lastTimeAttack;

    
    public PlantImpl(final double damage, final double remainingLife, final String entityName, final double timeBetweenAttacks, final Pair<Integer, Integer> position, final long cooldown){
        this.damage = damage;
        this.remainingLife = remainingLife;
        this.entityName = entityName;
        this.timeBetweenAttacks = timeBetweenAttacks;
        this.position = position;
        this.cooldown = cooldown;
        this.lastTimeAttack = 0;
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
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean isAlive() {
        if(remainingLife > 0) return true;
        return false;
    }

    @Override
    public String getEntityName() {
       return "Plant"; //return this.entityName;
    }

    @Override
    public double getTimeBetweenAttacks() {
        return this.timeBetweenAttacks;
    }

    @Override
    public void receiveDamage(double damageReceived) {
        this.remainingLife = this.remainingLife - damageReceived;
    }

    @Override
    public long getCooldown() {
        return this.cooldown;
    }

    @Override
    public void setLastTimeAttack(long lastTimeAttack) {
        this.lastTimeAttack = lastTimeAttack;
    }

    @Override
    public long getLastTimeAttack() {
        return this.lastTimeAttack;
    }

}
