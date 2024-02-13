package pvzclone.model.impl;

import pvzclone.model.api.Sun;

/**
 * Implementation of the Sun interface.
 * 
 * @author Sofia Caberletti
 */
public final class SunImpl implements Sun {
    private static final String NAME = "Sun";
    private static final int POINTS = 25;
    private static final int SCREEN_BOTTOM = 700;
    private static final int IMAGE_HEIGHT = 150;
    private final Integer speedYAxis;
    private boolean isAlive;
    private Pair<Integer, Integer> position;

    /**
     * 
     * @param position starting position of the sun.
     * @param speedYAxis speed of movement.
     */
    public SunImpl(final Pair<Integer, Integer> position, final Integer speedYAxis) {
        this.isAlive = true;
        this.position = position;
        this.speedYAxis = speedYAxis;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public String getEntityName() {
        return NAME;
    }

    @Override
    public void kill() {
        this.isAlive = false;
    }

    @Override
    public int getPoints() {
        if (!this.isAlive && this.position.getY() != SCREEN_BOTTOM) {
            return POINTS;
        }
        return 0;
    }

    @Override
    public double getSpeed() {
        return this.speedYAxis;
    }

    @Override
    public void moveDown() {
        this.position = new Pair<>(this.position.getX(), this.position.getY() + this.speedYAxis);
        if (this.position.getY() + IMAGE_HEIGHT >= SCREEN_BOTTOM) {
            this.kill();
        }
    }
}
