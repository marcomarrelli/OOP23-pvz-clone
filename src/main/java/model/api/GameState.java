package model.api;

public interface GameState {

    void incKilledZombies();

    void incSunScore();

    void decSunScore(final int costPlant);
    
    int getKilledZombies();

    int getSunScore();


}
