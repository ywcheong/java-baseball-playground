package numball.infra.view;

import textgame.view.GameView;

import java.util.List;

public class GameWelcomesView implements GameView {
    private final String message = String.join("\n", List.of(
            "==========================================",
            "숫자 야구 게임에 오신 것을 환영합니다!",
            "규칙은 README.md를 참조하세요.",
            "게임을 포기하려면 000을 입력하세요.",
            "",
            "엔터 키를 눌러 시작합니다...",
            "=========================================="
    ));

    @Override
    public String render() {
        return message;
    }
}
