package model.impl;

import model.api.GameState;
import model.api.World;

public class GameStateImpl implements GameState {

    private static final int INC_SUN = 25;
    private final World world;
    private final int totZombies;
    private int killedZombies;
    private int sunScore;

    public GameStateImpl(final int totZombies, final World world) {
        this.world= world;
        this.totZombies=totZombies;
        this.killedZombies=0;
        this.sunScore=0;
    }

    @Override
    public void incKilledZombies() {
        this.killedZombies = this.killedZombies + 1;    
    }

    @Override
    public void incSunScore() {
        this.sunScore = this.sunScore + INC_SUN;
    }

    @Override
    public void decSunScore(int costPlant) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'decSunScore'");
    }

    @Override
    public int getKilledZombies() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getKilledZombies'");
    }

    @Override
    public int getSunScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSunScore'");
    }

    @Override
    public boolean isGameOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isGameOver'");
    }
    
}
