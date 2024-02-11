package model.impl;

import model.api.Game;
import model.api.GameState;
import model.api.Plant;
import model.api.World;
import model.api.Zombie;

import java.util.List;
import java.util.ArrayList;


public class GameImpl implements Game{

    private static final int DELTA=1;
    private static final int timeRechargeAttackZombie = 2000;

    private final World world;
    private final GameState gameState;
    private List<PlantImpl> plants = new ArrayList<>();
    private List<ZombieImpl> zombies = new ArrayList<>();
    private List<SunImpl> suns= new ArrayList<>();
    private List<BulletImpl> bullets = new ArrayList<>();

    public GameImpl(final World world){
        this.world= world;
        this.gameState = new GameStateImpl(timeRechargeAttackZombie);
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
            //move zombie
        }
        for (var sun : this.suns) {
            sun.moveDown();
        }
        for (var bullet : bullets) {
            //move bullet
        }
    }

    @Override
    public void update() {
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
                if(zombie.getPosition().getX() < plant.getPosition().getX() + DELTA){
                    zombieEatPlant(zombie, plant);
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
