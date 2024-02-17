package pvzclone.model.impl;

import pvzclone.model.api.Plant;

/**
 * class that implements Plant interface.
 */

public final class PlantImpl implements Plant {

    /**
     * is the cost of the plant.
     */
    public static final int PLANT_COST = 100;

    private final double damage;
    private final String entityName;
    private final Pair<Integer, Integer> position;
    private final long cooldown;

    private double remainingLife;
    private long lastTimeAttack;

    /**
     * 
     * @param damage        is the damage that the plant do
     * @param remainingLife is the remaining life of the plant
     * @param entityName    is the name of the entity, for the plant is "plant"
     * @param position      is the position of the plant
     * @param cooldown      is the time between two attack of the plant
     */
    public PlantImpl(final double damage, final double remainingLife, final String entityName,
            final Pair<Integer, Integer> position, final long cooldown) {
        this.damage = damage;
        this.remainingLife = remainingLife;
        this.entityName = entityName;
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
        return this.remainingLife > 0;
    }

    @Override
    public String getEntityName() {
        return this.entityName;
    }

    @Override
    public void receiveDamage(final double damageReceived) {
        this.remainingLife = this.remainingLife - damageReceived;
    }

    @Override
    public long getCooldown() {
        return this.cooldown;
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
    public int getPlantCost() {
        return PlantImpl.PLANT_COST;
    }

}
