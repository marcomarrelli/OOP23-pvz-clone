package model.impl;

import javafx.util.Pair;
import model.api.Zombie;

public class ZombieImpl implements Zombie {

    private final double damage;
    private final double zombieSpeed;
    private final double timeRechargeAttack; /*long? */

    private double remainingLife;
    private Pair<Double,Double> position;


    public ZombieImpl(final double damage, final double timeRA, final double zombieSpeed,
        final double maxLife, final Pair<Double,Double> position){
        this.damage = damage;
        this.timeRechargeAttack = timeRA;
        this.zombieSpeed = zombieSpeed;
        this.remainingLife = maxLife;
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
        return this.remainingLife > 0 ? true : false;
    }

    @Override
    public String getEntityName() {
        return "Zombie";
    }

    @Override
    public double getZombieSpeed() {
        return this.getZombieSpeed();
    }

    @Override
    public void receiveDamage(double damageReceived) {
        this.remainingLife = this.remainingLife - damageReceived;
    }
    
}
