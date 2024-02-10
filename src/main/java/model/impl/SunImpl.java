package model.impl;

import model.api.Sun;

public class SunImpl implements Sun {
    private final static String NAME= "Sun";
    private final static Integer POINTS= 25;
    private final static Double SCREEN_BOTTOM= 600.0;
    private boolean isAlive;
    private Pair<Double, Double> position;

    public SunImpl(final Pair<Double, Double> position) {
        this.isAlive= true;
        this.position= position;
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
    public Integer getPoints() {
        if(!this.isAlive && !(this.position.getY()==SCREEN_BOTTOM)){
            return POINTS;
        }
        return 0;
    }

    @Override
    public void moveDown() {
        this.position= new Pair<>(this.position.getX(), this.position.getY()+1.0);
        if(this.position.getY()==SCREEN_BOTTOM) {
            this.kill();
        }
    }
    
}
