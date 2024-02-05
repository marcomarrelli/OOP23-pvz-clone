package model.impl;

import javafx.util.Pair;
import model.api.Zombie;

public class ZombieImpl implements Zombie {

    private final double damage;
    private final double zombieSpeed;
    private final double timeRechargeAttack; //tempo che impiega per togliere un tot (powerattack) di vita alla pianta
    private double remainingLife;
    private boolean isZombieAlive;
    private Pair<Double,Double> position;


    public ZombieImpl(final double dmg, final double tRA, final double zS,
            final double maxLife, final boolean ZA, final Pair<Double,Double> pstn){
        this.damage = dmg;
        this.timeRechargeAttack = tRA;
        this.zombieSpeed = zS;
        this.remainingLife = maxLife;
        this.isZombieAlive = ZA;
        this.position = pstn;
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
