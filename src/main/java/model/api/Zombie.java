package model.api;

public interface Zombie extends EntitiesFight {
    
    /**
     * @return the speed of Zombies
     */
    public double getZombieSpeed();

    /**
     * 
     * @return the time that a zombie takes to recharge the attack (eat a plant)
     */
    public long getTimeRechargeAttack();

}
