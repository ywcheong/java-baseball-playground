package textgame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JointGameViewTest {

    static class StubView implements GameView {
        private final String content;

        StubView(String content) {
            this.content = content;
        }

        @Override
        public String render() {
            return content;
        }
    }

    @Test
    @DisplayName("여러 뷰를 합칠 수 있다")
    void render_joinsMultipleViewsWithNewline() {
        // given
        GameView view1 = new StubView("첫 번째 화면");
        GameView view2 = new StubView("두 번째 화면");
        GameView joint = new JointGameView(view1, view2);

        // when
        String result = joint.render();

        // then
        assertEquals("첫 번째 화면\n두 번째 화면", result);
    }
}
