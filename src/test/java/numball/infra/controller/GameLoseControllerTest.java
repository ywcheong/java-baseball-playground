package numball.infra.controller;

import numball.domain.plate.Plate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("통합 테스트: 패배 흐름")
class GameLoseControllerTest {

    @Test
    @DisplayName("패배하면 게임 종료이다")
    void alwaysOver() {
        // given
        Plate answer = Plate.from("123");
        GameLoseController controller = new GameLoseController(answer);

        // when
        boolean result = controller.isGameOver();

        // then
        assertThat(result).isTrue();
    }
}
