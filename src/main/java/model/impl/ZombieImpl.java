package model.impl;

import model.api.Zombie;

public class ZombieImpl implements Zombie {

    private final double powerAttack;
    private final double zombieSpeed;
    private final double timeRechargeAttack; //tempo che impiega per togliere un tot (powerattack) di vita alla pianta
    private double remainingLife;
    private boolean isZombieAlive;
    // position


    public ZombieImpl(double pA, double tRA, double maxLife, boolean ZA, double zS){
        this.powerAttack = pA;
        this.timeRechargeAttack = tRA;
        this.zombieSpeed = zS;
        this.remainingLife = maxLife;
        this.isZombieAlive = ZA;
        
    }

    @Override
    public double getPowerAttack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPowerAttack'");
    }

    @Override
    public double getRemainingLife() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRemainingLife'");
    }

    @Override
    public void getPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPosition'");
    }

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAlive'");
    }

    @Override
    public String getEntityName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEntityName'");
    }

    @Override
    public double getZombieSpeed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getZombieSpeed'");
    }
    
}
