package model.impl;

import model.api.Sun;

/**
 * Implementation of the Sun interface.
 * 
 * @author Sofia Caberletti
 */
public class SunImpl implements Sun {
    private final static String NAME= "Sun";
    private final static int POINTS= 25;
    private final Integer speedYAxis;
    private final static int SCREEN_BOTTOM= 700;
    private boolean isAlive;
    private Pair<Integer, Integer> position;

    public SunImpl(final Pair<Integer, Integer> position, final Integer speedYAxis) {
        this.isAlive= true;
        this.position= position;
        this.speedYAxis= speedYAxis;
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
        this.isAlive= false;
    }

    @Override
    public int getPoints() {
        if(!this.isAlive && !(this.position.getY()==SCREEN_BOTTOM)){
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
        this.position= new Pair<Integer, Integer>(this.position.getX(), this.position.getY()+this.speedYAxis);
        if(this.position.getY()+150>=SCREEN_BOTTOM) {
            this.kill();
        }
    }
}
