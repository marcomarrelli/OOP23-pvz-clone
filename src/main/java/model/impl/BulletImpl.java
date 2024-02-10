package model.impl;

import model.api.Bullet;

public class BulletImpl implements Bullet{

    private Pair<Double, Double> position;
    private final double speed = 2;

    @Override
    public Pair<Double, Double> getPosition() {
        return position;
    }

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAlive'");
    }

    @Override
    public String getEntityName() {
        return "bullet";
    }

    @Override
    public double getSpeed() {
        return speed;
    }
    
}
