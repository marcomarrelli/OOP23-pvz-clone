package model.api;
/**
 * This interface models methods for Zombies and Plants.
 * @author Margherita Zanchini, Sofia Lotti.
 */
public interface ActiveEntities extends Entities {
    /**
     * Sets the respective field.
     * 
     * @param lastTimeAttack time since the last attack.
     */
    void setLastTimeAttack(long lastTimeAttack);
    /**
     * This method decreases Health Points.
     * 
     * @param damageReceived Attack Damage that entity has received.
     */
    void receiveDamage(double damageReceived);
    /**
     * @return time since the lasta attack.
     */
    long getLastTimeAttack();
    /**
     * @return entity's Attack Damage.
     */
    double getDamage();
    /**
     * @return entity's Health Points.
     */
    double getRemainingLife();
    /**
     * @return time needed to start and finish an attack.
     */
    long getCooldown();
}
