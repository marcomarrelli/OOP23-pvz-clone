package model.impl;

import model.api.Sun;

public class SunImpl implements Sun {
    private final static String NAME= "Sun";
    private final static int POINTS= 25;
    private final  double speedYAxis;
    private final static double SCREEN_BOTTOM= 700.0;
    private boolean isAlive;
    private Pair<Double, Double> position;

    public SunImpl(final Pair<Double, Double> position, final double speedYAxis) {
        this.isAlive= true;
        this.position= position;
        this.speedYAxis= speedYAxis;
    }

    @Override
    public Pair<Double, Double> getPosition() {
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

    /*@Override
    public void moveDown() {
        this.position= new Pair<>(this.position.getX(), this.position.getY()+1.0);
        if(this.position.getY()==screenHeight) {
            this.kill();
        }
    }*/
    
}
