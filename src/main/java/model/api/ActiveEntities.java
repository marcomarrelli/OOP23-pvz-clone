package model.api;
/**
 * This interface models methods for Zombies and Plants.
 * @authors Margherita Zanchini, Sofia Lotti.
 */
public interface ActiveEntities extends Entities {
    /**
     * Sets the respective field.
     * 
     * @param LastTimeAttack time since the last attack.
     */
    public void setLastTimeAttack(long lastTimeAttack);
    /**
     * This method decreases Health Points.
     * 
     * @param damageReceived Attack Damage that entity has received.
     */
    public void receiveDamage(double damageReceived);
    /**
     * @return time since the lasta attack.
     */
    public long getLastTimeAttack();
    /**
     * @return entity's Attack Damage.
     */
    public double getDamage();
    /**
     * @return entity's Health Points.
     */
    public double getRemainingLife();
    /**
     * @return time needed to start and finish an attack.
     */
    public long getCooldown();
}
