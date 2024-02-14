package pvzclone.model.impl;

import java.util.Set;

import pvzclone.model.api.Bullet;
import pvzclone.model.api.Entities;
import pvzclone.model.api.Game;
import pvzclone.model.api.GameState;
import pvzclone.model.api.Plant;
import pvzclone.model.api.Sun;
import pvzclone.model.api.World;
import pvzclone.model.api.Zombie;

import java.util.HashSet;

/**
 * class that implements the interface Game.
 */
public final class GameImpl implements Game {

    private static final int HOUSE_X_POSITION = 150;
    private static final long DELTA_TIME_SUN = 2000;
    private static final int BULLET_SPEED = 2;

    // zombie
    private static final int DELTA_ZOMBIE = 10;
    private static final long DELTA_TIME_ZOMBIE_START = 12_000;
    private static final int DEC_ZOMBIE_TIME_GENERATE = 500;

    // base plant
    private static final int DAMAGE_BASE_PLANT = 10;
    private static final int LIFE_BASE_PLANT = 100;
    private static final int COOLDOWN_BASE_PLANT = 20;
    private static final int DELTA_PLANT = 35;
    private static final int DELTA_Y_PLANT = 63;

    // private static final long DELTA_TIME_ZOMBIE= 15000;
    // private static final long DELTA_TIME_BULLET= 2000;
    // private static final int timeRechargeAttackZombie = 2000;

    private final World world;
    private final GameState gameState;
    private final SunsFactory sunFactory;
    private final ZombiesFactory zombiesFactory;

    private final Set<Plant> plants = new HashSet<>();
    private final Set<Zombie> zombies = new HashSet<>();
    private final Set<Bullet> bullets = new HashSet<>();
    private Set<Sun> suns = new HashSet<>();

    private long timeOfLastCreatedSun;
    private long timeOfLastCreatedZombie;
    private long deltaTimeZombie = DELTA_TIME_ZOMBIE_START;

    /**
     * 
     * @param world is the world.
     */
    public GameImpl(final World world) {
        this.world = world;
        this.gameState = new GameStateImpl(this.world.getLevel().getZombieCount());
        this.sunFactory = new SunsFactory();
        this.zombiesFactory = new ZombiesFactory();
    }

    @Override
    public boolean isOver() {
        if (this.gameState.areZombieAllKilled()) {
            return true;
        }
        for (final var zombie : zombies) {
            if (zombie.getPosition().getX() <= HOUSE_X_POSITION) {
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
        for (final var zombie : this.zombies) {
            zombie.moveLeft();
        }
        for (final var sun : this.suns) {
            sun.moveDown();
        }
        for (final var bullet : this.bullets) {
            bullet.move();
        }
    }

    private void removeKilledSuns() {
        final Set<Sun> remainingSuns = new HashSet<>();
        for (final var sun : this.suns) {
            if (sun.isAlive()) {
                remainingSuns.add(sun);
            }
        }
        this.suns = remainingSuns;
    }

    private boolean hasDeltaTimePassed(final long previousTime, final long currentTime, final long delta) {
        return (currentTime - previousTime) >= delta;
    }

    private void newSunGenerate(final long currentTime) {
        if (this.hasDeltaTimePassed(this.timeOfLastCreatedSun, currentTime, DELTA_TIME_SUN)) {
            this.suns.add((SunImpl) this.sunFactory.createEntity());
            this.timeOfLastCreatedSun = currentTime;
        }
    }

    private void newZombieGenerate(final long elapsed) {
        if (hasDeltaTimePassed(this.timeOfLastCreatedZombie, elapsed, deltaTimeZombie)) {
            this.timeOfLastCreatedZombie = elapsed;
            this.zombies.add((Zombie) this.zombiesFactory.createEntity());
            this.deltaTimeZombie = this.deltaTimeZombie - DEC_ZOMBIE_TIME_GENERATE;
        }
    }

    @Override
    public void update(final long elapsed) {
        this.checkCollision();
        this.removeKilledSuns();
        this.moveEntities();
        this.newSunGenerate(elapsed);
        this.newZombieGenerate(elapsed);
    }

    @Override
    public void createWave() {
        final int percentage = this.world.getLevel().getZombieCount();
        final Set<Entities> newWave = this.zombiesFactory.createEntities(percentage);
        for (final Entities singleZombieInWave : newWave) {
            this.zombies.add((Zombie) singleZombieInWave);
        }
    }

    @Override
    public void createPlant(final Pair<Integer, Integer> position) {
        plants.add(new PlantImpl(DAMAGE_BASE_PLANT, LIFE_BASE_PLANT, "Plant", position, COOLDOWN_BASE_PLANT));
    }

    @Override
    public void mouseEvent(final Pair<Integer, Integer> posClick) {
        // qua il model guarda dove è stato fatto il click e di conseguenza gestisce
        // l'evento
        // se è stato fatto su un sole o sulla pianta o il secondo click della pianta
    }

    /**
     * this method checks all of the collisions.
     * if a zombie is in the same position of the plant then it should eat it.
     * if a bullet collides with a zombie.
     * 
     * @author Zanchini Margherita
     */
    private void checkCollision() {
        for (final Zombie zombie : zombies) {
            for (final Plant plant : plants) {
                if(plant.getPosition().getY() == zombie.getPosition().getY() + DELTA_Y_PLANT
                    || plant.getPosition().getY() == zombie.getPosition().getY() + DELTA_Y_PLANT -3){
                    if(zombie.getPosition().getX() <= plant.getPosition().getX() + DELTA_PLANT) {
                        zombieEatPlant(zombie, plant);
                        if (!plant.isAlive()) {
                            plants.remove(plant); // togliere un oggetto da un set in foeach potrebbe dare problemi
                        }
                    }
                }
            }
        }
        for (final Bullet bullet : bullets) {
            for (final Zombie zombie : zombies) {
                if (zombie.getPosition().getY().equals(bullet.getPosition().getY())
                && bullet.getPosition().getX() >= zombie.getPosition().getX() - DELTA_ZOMBIE) {
                    zombie.receiveDamage(bullet.getDamage());
                    bullets.remove(bullet);
                    if (!zombie.isAlive()) {
                        zombies.remove(zombie);
                    }
                }
            }
        }

    }

    /**
     * this method handles the case of collision of a zombie and a plant.
     * the plant takes damage.
     * and then we check if the plant is still alive after the damage received.
     * if not we remove it from the list of all the plants.
     * 
     * @author Zanchini Margherita
     * @param zombie the zombie that eats the plant
     * @param plant  the plant that is eaten by the zombie
     */
    private void zombieEatPlant(final Zombie zombie, final Plant plant) {
        final long zombieLastAttack = zombie.getLastTimeAttack();
        final long currentTime = System.currentTimeMillis();
        if (currentTime - zombieLastAttack > zombie.getCooldown()) {
            plant.receiveDamage(zombie.getDamage());
            zombie.setLastTimeAttack(currentTime);
        }
    }

    /**
     * method that check all the plants that need to shoot.
     * and if they have to shoot creates a new bullet.
     * 
     * @authore Zanchini Margherita
     */
    private void plantsShoot() {
        for (final Plant plant : plants) {
            for(final Zombie zombie : zombies){
                if(plant.getPosition().getY() == zombie.getPosition().getY() + DELTA_Y_PLANT
                    || plant.getPosition().getY() == zombie.getPosition().getY() + DELTA_Y_PLANT -3){
                    final long plantLastAttack = plant.getLastTimeAttack();
                    final long currentTime = System.currentTimeMillis();
                    if (currentTime - plantLastAttack > plant.getCooldown()) {
                        // da riguardare la posizione da passare al bullet, non sarà esattamente quella
                        // della pianta ma un pelo più avanti
                        bullets.add(new BulletImpl(BULLET_SPEED, plant.getDamage(), plant.getPosition()));
                        plant.setLastTimeAttack(currentTime);
                    }
                }
            }
        }
    }

    @Override
    public GameState getGameState() {
        return this.gameState;
    }

    @Override
    public Set<Entities> getEntities() {
        final Set<Entities> entities = new HashSet<>();
        entities.addAll(plants);
        entities.addAll(zombies);
        entities.addAll(suns);
        entities.addAll(bullets);
        return entities;
    }
}
