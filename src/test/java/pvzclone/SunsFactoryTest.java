package pvzclone;

import org.junit.jupiter.api.BeforeEach;

import pvzclone.model.api.EntitiesFactory;
import pvzclone.model.impl.SunsFactory;

public class SunsFactoryTest {
    private EntitiesFactory sunsFactory;

    @BeforeEach
    private void initTest() {
        this.sunsFactory = new SunsFactory();
    }
}
