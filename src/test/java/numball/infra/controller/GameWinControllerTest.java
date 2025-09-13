package numball.infra.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("통합 테스트: 승리 흐름")
class GameWinControllerTest {
    @Test
    @DisplayName("승리하면 게임 종료이다")
    void alwaysOver() {
        // given
        GameWinController controller = new GameWinController();

        // when
        boolean result = controller.isGameOver();

        // then
        assertThat(result).isTrue();
    }
}
