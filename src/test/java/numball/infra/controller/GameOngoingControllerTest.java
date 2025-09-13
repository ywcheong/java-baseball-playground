package numball.infra.controller;

import numball.domain.plate.Plate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import textgame.controller.GameController;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("통합 테스트: 게임중 흐름")
class GameOngoingControllerTest {

    @Test
    @DisplayName("정답 입력 시 승리 흐름으로 이동한다")
    void winWhenCorrectAnswer() {
        // given
        Plate answer = Plate.from("123");
        GameOngoingController controller = new GameOngoingController(answer, null);

        // when
        GameController next = controller.doActionWithPlayerInput("123");

        // then
        assertThat(next).isInstanceOf(GameWinController.class);
    }

    @Test
    @DisplayName("포기 입력(000) 시 패배 흐름으로 이동한다")
    void loseWhenGiveUp() {
        // given
        Plate answer = Plate.from("123");
        GameOngoingController controller = new GameOngoingController(answer, null);

        // when
        GameController next = controller.doActionWithPlayerInput("000");

        // then
        assertThat(next).isInstanceOf(GameLoseController.class);
    }

    @Test
    @DisplayName("오답 입력 시에도 게임중 흐름은 계속된다")
    void winWhenIncorrectAnswer() {
        // given
        Plate answer = Plate.from("123");
        GameOngoingController controller = new GameOngoingController(answer, null);

        // when
        GameController next = controller.doActionWithPlayerInput("124");

        // then
        assertThat(next).isInstanceOf(GameOngoingController.class);
    }

    @Test
    @DisplayName("올바르지 않은 입력 시에도 게임중 흐름은 계속된다")
    void invalidInputLeadsToExceptionView() {
        // given
        Plate answer = Plate.from("123");
        GameOngoingController controller = new GameOngoingController(answer, null);

        // when
        GameController next = controller.doActionWithPlayerInput("1a3"); // 유효하지 않은 문자

        // then
        assertThat(next).isInstanceOf(GameOngoingController.class);
    }
}
