package pvzclone.model.impl;

import java.util.Set;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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
import java.util.Random;

/**
 * class that implements the interface Game.
 */
@SuppressFBWarnings(value = {
        "EI_EXPOSE_REP2",
        "EI_EXPOSE_REP"
}, justification = "world is intended to be updated outside"
        + "GameState is intended to be modified")
public final class GameImpl implements Game {

    private static final int HOUSE_X_POSITION = 150;

    // Zombie
    private static final int DELTA_ZOMBIE = 10;
    private static final int DELTA_TIME_FIRST_ZOMBIE = 4000;

    // Base plant
    private static final int DAMAGE_BASE_PLANT = 20;
    private static final int LIFE_BASE_PLANT = 100;
    private static final int COOLDOWN_BASE_PLANT = 3000;
    private static final int DELTA_PLANT = 35;
    private static final int DELTA_Y_PLANT = 63;

    // Bullet
    private static final int DELTA_X_BULLET = 30;
    private static final int BULLET_SPEED = 15;

    private final World world;
    private final GameState gameState;
    private final SunsFactory sunFactory;
    private final ZombiesFactory zombiesFactory;

    private Set<Plant> plants = new HashSet<>();
    private Set<Zombie> zombies = new HashSet<>();
    private Set<Bullet> bullets = new HashSet<>();
    private Set<Sun> suns = new HashSet<>();

    private final long deltaTimeSunDecrement;
    private final long deltaTimeZombieDecrement;

    private long timeOfLastCreatedSun;
    private long timeOfLastCreatedZombie;
    private long deltaTimeSun;
    private long deltaTimeZombie;

    private boolean canSingleZombieGenerate;
    private int wavePassed;

    private final Random random = new Random();

    /**
     * 
     * @param world is the world.
     */
    public GameImpl(final World world) {
        this.world = world;
        this.gameState = new GameStateImpl(this.world.getLevel().getZombieCount());
        this.sunFactory = new SunsFactory();
        this.zombiesFactory = new ZombiesFactory();

        this.deltaTimeSun = this.world.getLevel().getSunSpawnRate();
        this.deltaTimeZombie = this.world.getLevel().getZombieSpawnRate();
        this.deltaTimeSunDecrement = this.world.getLevel().getSunSpawnRateDecrementRange();
        this.deltaTimeZombieDecrement = this.world.getLevel().getZombieSpawnRateDecrementRange();

        this.canSingleZombieGenerate = true;
    }

    @Override
    public boolean isOver() {
        if (this.gameState.areZombieAllKilled()) {
            this.gameState.setWinState(true);
            return true;
        }
        for (final var zombie : zombies) {
            if (zombie.getPosition().getX() <= HOUSE_X_POSITION) {
                this.gameState.setWinState(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Method that updates the positions of every entity
     * present in the game.
     */
    private void moveEntities() {
        for (final var zombie : this.zombies) {
            if (zombie.isCanGo()) {
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
        if (this.hasDeltaTimePassed(this.timeOfLastCreatedSun, currentTime, this.deltaTimeSun)) {
            this.timeOfLastCreatedSun = currentTime;
            this.suns.add((SunImpl) this.sunFactory.createEntity());
            final long deltaDecrement = this.random.nextLong(2 * this.deltaTimeSunDecrement)
                    - this.deltaTimeSunDecrement;
            this.deltaTimeSun = this.deltaTimeSun - deltaDecrement;
        }
    }

    private void newZombieGenerate(final long elapsed) {
        if (hasDeltaTimePassed(this.timeOfLastCreatedZombie, elapsed, deltaTimeZombie)
                && this.canSingleZombieGenerate
                || hasDeltaTimePassed(this.timeOfLastCreatedZombie, elapsed,
                        DELTA_TIME_FIRST_ZOMBIE)
                        && this.gameState.getZombiesGenerated() == 0) {
            this.timeOfLastCreatedZombie = elapsed;
            this.zombies.add((Zombie) this.zombiesFactory.createEntity());

            final long deltaDecrement = this.random.nextLong(2 * this.deltaTimeZombieDecrement)
                    - this.deltaTimeZombieDecrement;
            this.deltaTimeZombie = this.deltaTimeZombie - deltaDecrement;

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
        this.createWave();
        this.newZombieGenerate(elapsed);
    }

    /**
     * Creates a wave of zombies in the game.
     * This method is responsible for spawning a new wave of zombies.
     */
    private void createWave() {
        final int totZombies = this.world.getLevel().getZombieCount();
        final int totzombieWave = this.world.getLevel().getZombieCountInWave();

        if (this.gameState.getZombiesGenerated() >= totZombies - totzombieWave
                && this.wavePassed < this.world.getLevel().getZombieWaveCount()) {
            this.canSingleZombieGenerate = false;
            this.wavePassed = this.wavePassed + 1;
            final Set<Entities> newWave = this.zombiesFactory.createEntities(totzombieWave);
            for (final Entities singleZombieInWave : newWave) {
                this.zombies.add((Zombie) singleZombieInWave);
                this.gameState.incZombiesGenerated();
            }
        }
    }

    @Override
    public boolean createPlant(final Pair<Integer, Integer> position) {
        if (this.gameState.getSunScore() >= PlantImpl.PLANT_COST) {
            final PlantImpl newPlant = new PlantImpl(DAMAGE_BASE_PLANT, LIFE_BASE_PLANT, "Plant", position,
                    COOLDOWN_BASE_PLANT);
            plants.add(newPlant);
            this.gameState.decSunScore(newPlant.getPlantCost());
            return true;
        }
        return false;
    }

    /**
     * This method checks all of the collisions.
     * If a zombie is in the same position of the plant then it should eat it.
     * If a bullet collides with a zombie.
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
                final int plantX = plant.getPosition().getX();
                final int plantY = plant.getPosition().getY();
                final int zombieX = zombie.getPosition().getX();
                final int zombieY = zombie.getPosition().getY();

                if ((plantY == zombieY + DELTA_Y_PLANT || plantY == zombieY + DELTA_Y_PLANT - 3)
                        && zombieX <= plantX + DELTA_PLANT) {
                    zombieEatPlant(zombie, plant);
                    zombie.setCanGo(false);
                    if (!plant.isAlive()) {
                        plantTemp.remove(plant);
                        zombie.setCanGo(true);
                    }
                }
            }
        }
        for (final Bullet bullet : bullets) {
            for (final Zombie zombie : zombies) {
                final int bulletX = bullet.getPosition().getX();
                final int bulletY = bullet.getPosition().getY();
                final int zombieX = zombie.getPosition().getX();
                final int zombieY = zombie.getPosition().getY();

                if ((bulletY == zombieY + DELTA_Y_PLANT || bulletY == zombieY + DELTA_Y_PLANT - 3)
                        && bulletX >= zombieX - DELTA_ZOMBIE) {
                    zombie.receiveDamage(bullet.getDamage());
                    bulletTemp.remove(bullet);
                    if (!zombie.isAlive()) {
                        zombieTemp.remove(zombie);
                        this.gameState.incKilledZombies();
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
     * This method handles the case of collision of a zombie and a plant.
     * The plant takes damage.
     * And then we check if the plant is still alive after the damage received.
     * If not we remove it from the list of all the plants.
     * 
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
     * Method that checks all the plants that need to shoot
     * and if they have to shoot creates a new bullet.
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
                                new Pair<>(plant.getPosition().getX() + DELTA_X_BULLET, plant.getPosition().getY()),
                                "Bullet"));
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
