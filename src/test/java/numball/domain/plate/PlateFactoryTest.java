package numball.domain.plate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlateFactoryTest {
    @Test
    @DisplayName("랜덤한 플레이트가 생성된다")
    void canMakeRandomPlate() {
        // given - when - then
        PlateFactory.createRandomPlate();
    }
}