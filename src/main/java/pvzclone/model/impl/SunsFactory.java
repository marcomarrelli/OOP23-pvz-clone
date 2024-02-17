package pvzclone.model.impl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import pvzclone.model.api.Entities;
import pvzclone.model.api.EntitiesFactory;

/**
 * This class contains methods to create Sun entities.
 */
public final class SunsFactory implements EntitiesFactory {
    private static final int SPEED_Y_AXIS = 4;
    private static final int STARTING_X_GAME_FIELD = 220;
    private static final int FINAL_X_GAME_FIELD = 750;
    private static final int STARTING_Y_POSITIONIG = -15;
    private final Random random = new Random();

    @Override
    public Entities createEntity() {
        return new SunImpl(
            new Pair<Integer, Integer>(
            random.nextInt(FINAL_X_GAME_FIELD - STARTING_X_GAME_FIELD) + STARTING_X_GAME_FIELD, 
            STARTING_Y_POSITIONIG), 
            SPEED_Y_AXIS
        );
    }

    @Override
    public Set<Entities> createEntities(final int n) {
        final Set<Entities> sunsSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            sunsSet.add(createEntity());
        }
        return sunsSet;
    }
}
