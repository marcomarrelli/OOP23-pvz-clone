package model.impl;

import model.api.Bullet;

public class BulletImpl implements Bullet{

    private Pair<Integer, Integer> position;
    private final Integer speed;
    private final double damage;

    public BulletImpl(final Integer speed, final double damage, final Pair<Integer, Integer> pos){
        this.speed = speed;
        this.damage = damage;
        this.position = pos;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public String getEntityName() {
        return "Bullet";
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
        this.position = new Pair<Integer, Integer>(position.getX() + speed, position.getY());
    }    
}
