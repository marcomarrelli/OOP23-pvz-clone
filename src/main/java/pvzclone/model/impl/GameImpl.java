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
import pvzclone.view.impl.SwingViewImpl;

import java.util.HashSet;

/**
 * class that implements the interface Game.
 */
public final class GameImpl implements Game {

    // sun
    private static final int HOUSE_X_POSITION = 150;
    private static final long DELTA_TIME_SUN = 3300;
    private static final int BULLET_SPEED = 10;

    // zombie
    private static final int DELTA_ZOMBIE = 10;
    private static final long DELTA_TIME_ZOMBIE_START = 12_000;
    private static final int DEC_ZOMBIE_TIME_GENERATE = 500;

    // base plant
    private static final int PLANT_COST = 100;
    private static final int DAMAGE_BASE_PLANT = 20;
    private static final int LIFE_BASE_PLANT = 100;
    private static final int COOLDOWN_BASE_PLANT = 3000;
    private static final int DELTA_PLANT = 35;
    private static final int DELTA_Y_PLANT = 63;

    private static final int DELTA_X_BULLET = 30;

    private final World world;
    private final GameState gameState;
    private final SunsFactory sunFactory;
    private final ZombiesFactory zombiesFactory;

    private Set<Plant> plants = new HashSet<>();
    private Set<Zombie> zombies = new HashSet<>();
    private Set<Bullet> bullets = new HashSet<>();
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
            if (zombie.getCanGo()) {
                zombie.moveLeft();
            }
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
        if (hasDeltaTimePassed(this.timeOfLastCreatedZombie, elapsed, deltaTimeZombie)
                && this.gameState.getZombiesGenerated() < this.world.getLevel().getZombieCount()) {
            this.timeOfLastCreatedZombie = elapsed;
            this.zombies.add((Zombie) this.zombiesFactory.createEntity());
            this.deltaTimeZombie = this.deltaTimeZombie - DEC_ZOMBIE_TIME_GENERATE;
            this.gameState.incZombiesGenerated();
        }
    }

    @Override
    public void update(final long elapsed) {
        this.checkCollision();
        this.plantsShoot();
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
        if (this.gameState.getSunScore() >= 100) {
            final PlantImpl newPlant = new PlantImpl(DAMAGE_BASE_PLANT, LIFE_BASE_PLANT, "Plant", position,
                    COOLDOWN_BASE_PLANT, PLANT_COST);
            plants.add(newPlant);
            this.gameState.decSunScore(newPlant.getPlantCost());
        }
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
        final Set<Zombie> zombieTemp = new HashSet<>();
        final Set<Plant> plantTemp = new HashSet<>();
        final Set<Bullet> bulletTemp = new HashSet<>();
        bulletTemp.addAll(bullets);
        zombieTemp.addAll(zombies);
        plantTemp.addAll(plants);
        for (final Zombie zombie : zombies) {
            for (final Plant plant : plants) {
                if (plant.getPosition().getY() == zombie.getPosition().getY() + DELTA_Y_PLANT
                        || plant.getPosition().getY() == zombie.getPosition().getY() + DELTA_Y_PLANT - 3) {
                    if (zombie.getPosition().getX() <= plant.getPosition().getX() + DELTA_PLANT) {
                        zombieEatPlant(zombie, plant);
                        zombie.setCanGo(false);
                        if (!plant.isAlive()) {
                            plantTemp.remove(plant);
                            zombie.setCanGo(true);
                        }
                    }
                }
            }
        }
        for (final Bullet bullet : bullets) {
            for (final Zombie zombie : zombies) {
                if (bullet.getPosition().getY() == zombie.getPosition().getY() + DELTA_Y_PLANT
                        || bullet.getPosition().getY() == zombie.getPosition().getY() + DELTA_Y_PLANT - 3) {
                    if (bullet.getPosition().getX() >= zombie.getPosition().getX() - DELTA_ZOMBIE) {
                        zombie.receiveDamage(bullet.getDamage());
                        // bullets.remove(bullet);
                        bulletTemp.remove(bullet);
                        if (!zombie.isAlive()) {
                            // zombieTemp.add(zombie);
                            zombieTemp.remove(zombie);
                            this.gameState.incKilledZombies();
                        }
                    }
                }
            }
            if (bullet.getPosition().getX() > SwingViewImpl.APPLICATION_WIDTH) {
                bulletTemp.remove(bullet);
            }
        }
        this.bullets = bulletTemp;
        this.plants = plantTemp;
        this.zombies = zombieTemp;
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
            for (final Zombie zombie : zombies) {
                if (plant.getPosition().getY() == zombie.getPosition().getY() + DELTA_Y_PLANT
                        || plant.getPosition().getY() == zombie.getPosition().getY() + DELTA_Y_PLANT - 3) {
                    final long plantLastAttack = plant.getLastTimeAttack();
                    final long currentTime = System.currentTimeMillis();
                    if (currentTime - plantLastAttack > plant.getCooldown()) {
                        bullets.add(new BulletImpl(BULLET_SPEED, plant.getDamage(),
                                new Pair<>(plant.getPosition().getX() + DELTA_X_BULLET, plant.getPosition().getY())));
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
