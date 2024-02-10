package model.impl;

import model.api.Zombie;
/**
 * Class that implements Zombie Interface.
 * @author Sofia Lotti.
 */
public class ZombieImpl implements Zombie {

    private final double damage;
    private final double zombieSpeed;
    private final long timeRechargeAttack;

    private double remainingLife;
    private long lastTimeAttack;
    private Pair<Double,Double> position;
    /**
     * Constructor of Zombies.
     * 
     * @param damage damage that Zombie causes with each bite.
     * @param timeRA time needed to start and finish a bite.
     * @param zombieSpeed speed of the Zombie.
     * @param maxLife Zombie's inital life.
     * @param position Zombie's position.
     */
    public ZombieImpl(final double damage, final long timeRA, final double zombieSpeed,
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
        return this.zombieSpeed;
    }   
    
    @Override
    public long getCooldown() {
        return this.timeRechargeAttack;
    }
    
    @Override
    public void receiveDamage(double damageReceived) {
        this.remainingLife = this.remainingLife - damageReceived;
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
