package textgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import textgame.controller.GameController;
import textgame.exception.GameNotOverException;
import textgame.exception.GameOverException;
import textgame.view.GameView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("RedundantThrows")
class TextGameTest {

    @Test
    @DisplayName("게임 단계가 진행되면 다음 컨트롤러로 전환된다")
    void doGameStep_transitionsToNextController() throws Exception {
        // given
        StringWriter out = new StringWriter();
        BufferedReader in = new BufferedReader(new StringReader("player input\n"));
        GameController next = new DummyController(new DummyView("next view"), false, null);
        GameController start = new DummyController(new DummyView("start view"), false, next);
        TextGame game = new TextGame(start, in, new BufferedWriter(out));

        // when
        game.doGameStep();

        // then
        String output = out.toString();
        assertTrue(output.contains("start view"));
        assertFalse(game.isGameOver());
    }

    @Test
    @DisplayName("게임이 종료되었을 때 다음 단계로 진행하면 오류이다")
    void doGameStep_throwsWhenGameOver() throws Exception {
        // given
        GameController over = new DummyController(new DummyView("over"), true, null);
        TextGame game = new TextGame(over, new BufferedReader(new StringReader("")), new BufferedWriter(new StringWriter()));

        // when & then
        assertThrows(GameOverException.class, game::doGameStep);
    }

    @Test
    @DisplayName("게임 종료 화면 출력을 명령할 수 있다")
    void showGameOver_rendersFinalView() throws Exception {
        // given
        StringWriter out = new StringWriter();
        GameController over = new DummyController(new DummyView("final result"), true, null);
        TextGame game = new TextGame(over, new BufferedReader(new StringReader("")), new BufferedWriter(out));

        // when
        game.showGameOver();

        // then
        assertTrue(out.toString().contains("final result"));
    }

    @Test
    @DisplayName("게임이 종료되지 않았을 때 게임 종료 화면 출력을 명령하면 오류이다")
    void showGameOver_throwsIfNotOver() throws Exception {
        // given
        TextGame game = new TextGame(new DummyController(new DummyView("not over"), false, null), new BufferedReader(new StringReader("")), new BufferedWriter(new StringWriter()));

        // when & then
        assertThrows(GameNotOverException.class, game::showGameOver);
    }

    static class DummyView implements GameView {
        private final String msg;

        DummyView(String msg) {
            this.msg = msg;
        }

        @Override
        public String render() {
            return msg;
        }
    }

    static class DummyController implements GameController {
        private final GameView view;
        private final boolean gameOver;
        private final GameController nextController;

        DummyController(GameView view, boolean gameOver, GameController nextController) {
            this.view = view;
            this.gameOver = gameOver;
            this.nextController = nextController;
        }

        @Override
        public GameView getPreview() {
            return view;
        }

        @Override
        public GameController doActionWithPlayerInput(String userInput) {
            return nextController;
        }

        @Override
        public boolean isGameOver() {
            return gameOver;
        }
    }
}
