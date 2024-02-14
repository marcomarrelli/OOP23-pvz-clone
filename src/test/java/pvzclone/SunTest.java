package pvzclone;

import org.junit.jupiter.api.BeforeEach;

import pvzclone.model.api.Sun;
import pvzclone.model.impl.Pair;
import pvzclone.model.impl.SunImpl;

public class SunTest {
    private static final Pair<Integer, Integer> POSITION = new Pair<>(50, 50);
    private static final int SPEED = 5;
    private Sun sun;

    @BeforeEach
    private void initTest() {
        this.sun = new SunImpl(POSITION, SPEED);
    }
    
}
