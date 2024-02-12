package model.impl;

import model.api.Bullet;

public class BulletImpl implements Bullet{

    private Pair<Double, Double> position;
    private final double speed;
    private final double damage;
    private boolean alive;

    public BulletImpl(final double speed, final double damage){
        this.speed = speed;
        this.damage = damage;
        alive = true;
    }

    @Override
    public Pair<Double, Double> getPosition() {
        return position;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public String getEntityName() {
        return "bullet";
    }

    @Override
    public double getSpeed() {
        return this.speed;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public void move() {
        this.position = new Pair<Double,Double>(position.getX() + speed, position.getY());
    }

    @Override
    public void killBullet() {
        this.alive = false;
    }
    
}
