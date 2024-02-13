package model.impl;

import model.api.Zombie;

/**
 * Class that implements Zombie Interface.
 * 
 * @author Sofia Lotti.
 */
public final class ZombieImpl implements Zombie {

    private final double damage;
    private final int xShift;
    private final long cooldown;

    private double remainingLife;
    private long lastTimeAttack;
    private Pair<Integer, Integer> position;

    /**
     * Constructor of Zombies.
     * 
     * @param damage   damage that Zombie causes with each bite.
     * @param cooldown time needed to start and finish a bite.
     * @param xShift   speed of the Zombie.
     * @param maxLife  Zombie's inital life.
     * @param position Zombie's position.
     */
    public ZombieImpl(final double damage, final long cooldown, final int xShift,
            final double maxLife, final Pair<Integer, Integer> position) {
        this.damage = damage;
        this.cooldown = cooldown;
        this.xShift = xShift;
        this.remainingLife = maxLife;
        this.lastTimeAttack = 0;
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
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean isAlive() {
        return this.remainingLife > 0;
    }

    @Override
    public String getEntityName() {
        return "Zombie";
    }

    @Override
    public double getXShift() {
        return this.xShift;
    }

    @Override
    public long getCooldown() {
        return this.cooldown;
    }

    @Override
    public void receiveDamage(final double damageReceived) {
        this.remainingLife = this.remainingLife - damageReceived;
    }

    @Override
    public void setLastTimeAttack(final long lastTimeAttack) {
        this.lastTimeAttack = lastTimeAttack;
    }

    @Override
    public long getLastTimeAttack() {
        return this.lastTimeAttack;
    }

    @Override
    public void moveLeft() {
        this.position = new Pair<Integer, Integer>(this.position.getX() - this.xShift, this.position.getY());
    }

}
