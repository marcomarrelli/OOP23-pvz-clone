package pvzclone.model.impl;

import pvzclone.model.api.Bullet;

/**
 * class that implements the interface Bullet.
 */
public final class BulletImpl implements Bullet {

    private Pair<Integer, Integer> position;
    private final Integer speed;
    private final double damage;
    private final String name;

    /**
     * 
     * @param speed  the speed of the bullet
     * @param damage the damage of the bullet
     * @param pos    the position of the bullet
     * @param name   the name of the bullet
     */
    public BulletImpl(final Integer speed, final double damage, final Pair<Integer, Integer> pos, final String name) {
        this.speed = speed;
        this.damage = damage;
        this.position = pos;
        this.name = name;
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
        return this.name;
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
        this.position = new Pair<>(position.getX() + speed, position.getY());
    }
}
