package numball.infra.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import textgame.controller.GameController;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("통합 테스트: 환영 흐름")
class GameWelcomeControllerTest {

    @Test
    @DisplayName("플레이어 입력 후 게임중 흐름으로 넘어간다")
    void proceedToAnswerToPlayerController() {
        // given
        GameWelcomeController controller = new GameWelcomeController();

        // when
        GameController next = controller.doActionWithPlayerInput("임의입력");

        // then
        assertThat(next).isInstanceOf(GameOngoingController.class);
        assertThat(controller.isGameOver()).isFalse();
    }
}
