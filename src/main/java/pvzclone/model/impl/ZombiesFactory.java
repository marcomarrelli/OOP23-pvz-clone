package pvzclone.model.impl;

import java.util.Set;

import pvzclone.model.api.Entities;
import pvzclone.model.api.EntitiesFactory;

import java.util.HashSet;
import java.util.Random;

/**
 * Class that implements EntitiesFactory.
 */
public final class ZombiesFactory implements EntitiesFactory {
    private static final double ATK = 50;
    private static final int MAX_LIFE = 100;
    private static final int ZOMBIE_SPEED = 2;
    private static final long COOLDOWN = 3000;
    private static final int START_X_ZOMBIE = 800;
    private static final int START_Y_ZOMBIE = 50;
    private static final int DELTA_Y_ZOMBIE = 110;
    private static final int POSSIBLE_Y = 5;

    private final Random random;

    /**
     * Constructor of ZombiesFactory.
     */
    public ZombiesFactory() {
        this.random = new Random();
    }

    @Override
    public Entities createEntity() {
        return new ZombieImpl(ATK, COOLDOWN, ZOMBIE_SPEED, MAX_LIFE,
                new Pair<Integer, Integer>(START_X_ZOMBIE,
                        START_Y_ZOMBIE + DELTA_Y_ZOMBIE * this.random.nextInt(0, POSSIBLE_Y)));
    }

    @Override
    public Set<Entities> createEntities(final int n) {
        final Set<Entities> zombieSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            zombieSet.add(createEntity());
        }
        return zombieSet;
    }

}
