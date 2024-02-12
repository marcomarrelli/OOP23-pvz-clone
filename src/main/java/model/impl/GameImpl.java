package model.impl;

import model.api.Game;
import model.api.GameState;
import model.api.Plant;
import model.api.World;
import model.api.Zombie;

import java.util.*;


public class GameImpl implements Game{

    private static final int DELTA_PLANT=35;
    private static final int DELTA_ZOMBIE=10;
    private static final int timeRechargeAttackZombie = 2000;

    private final World world;
    private final GameState gameState;
    private Set<PlantImpl> plants = new HashSet<>();
    private Set<ZombieImpl> zombies = new HashSet<>();
    private Set<SunImpl> suns= new HashSet<>();
    private Set<BulletImpl> bullets = new HashSet<>();

    public GameImpl(final World world){
        this.world= world;
        this.gameState = new GameStateImpl(this.world.getLevel().getZombieCount());
    }

    @Override
    public boolean isOver() {
        if(this.gameState.areZombieAllKilled()) {
            return true;
        }
        for (var zombie : zombies) {
            if(zombie.getPosition().getX()<=200) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that updates the positions of every entity
     * present in the game.
     * 
     * @author Sofia Caberletti
     */
    private void moveEntities() {
        for (var zombie : this.zombies) {
            zombie.moveLeft();
        }
        for (var sun : this.suns) {
            sun.moveDown();
        }
        for (var bullet : bullets) {
            bullet.move();
        }
    }

    private void removeKilledEntities() {
        Set<ZombieImpl> remainingZombies = new HashSet<>();
        Set<SunImpl> remainingSuns = new HashSet<>();
        Set<BulletImpl> remainingBullets = new HashSet<>();
        for (var zombie : this.zombies) {
            if(zombie.isAlive()) {
                remainingZombies.add(zombie);
            }
        }
        for (var sun : this.suns) {
            if(sun.isAlive()) {
                remainingSuns.add(sun);
            }
        }
        for (var bullet : bullets) {
            remainingBullets.add(bullet);
        }
        this.zombies= remainingZombies;
        this.suns= remainingSuns;
        this.bullets= remainingBullets;
    }

    @Override
    public void update() {
        this.removeKilledEntities();
        this.moveEntities();
    }

    @Override
    public void createWave() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createWave'");
    }

    @Override
    public void createPlant(Pair<Double, Double> position) {
        plants.add(new PlantImpl(20, 100, "base plant", 2, position, 5));
    }

    public void mouseEvent(Pair<Double, Double> posClick){
        //qua il model guarda dove è stato fatto il click e di conseguenza gestisce l'evento
        //se è stato fatto su un sole o sulla pianta o il secondo click della pianta
    }

    /**
     * this method checks all of the collisions
     * if a zombie is in the same position of the plant then it should eat it
     * if a bullet collides with a zombie
     * 
     * @author Zanchini Margherita
     */
    public void checkCollision(){
        for (ZombieImpl zombie : zombies) {
            for (PlantImpl plant : plants) {
                if(zombie.getPosition().getY() == plant.getPosition().getY()){
                    if(zombie.getPosition().getX() <= plant.getPosition().getX() + DELTA_PLANT){
                        zombieEatPlant(zombie, plant);
                    }
                }
            }
        }
        for (BulletImpl bullet : bullets) {
            for (ZombieImpl zombie : zombies) {
                if(zombie.getPosition().getY() == bullet.getPosition().getY()){
                    if(bullet.getPosition().getX() >= zombie.getPosition().getX() - DELTA_ZOMBIE){
                        zombie.receiveDamage(bullet.getDamage());
                        bullets.remove(bullet);
                    }
                }
            }
        }

    }
    
    /**
     * this method handles the case of collision of a zombie and a plant
     * the plant takes damage
     * and then we check if the plant is still alive after the damage received
     * if not we remove it from the list of all the plants
     * 
     * @author Zanchini Margherita
     * @param zombie the zombie that eats the plant
     * @param plant  the plant that is eaten by the zombie
     */
    private void zombieEatPlant(Zombie zombie, Plant plant){
        long zombieLastAttack = zombie.getLastTimeAttack();
        long currentTime = System.currentTimeMillis();
        if( currentTime-zombieLastAttack > zombie.getCooldown()){
            plant.receiveDamage(zombie.getDamage());
            if(!plant.isAlive()){
                plants.remove(plant);
            }
        }
    }

    @Override
    public GameState getGameState() {
        return this.gameState;
    }    
}
