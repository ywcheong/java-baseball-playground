package numball.infra.view;

import textgame.view.GameView;

public class GameDecideAnswerView implements GameView {
    @Override
    public String render() {
        return "컴퓨터가 비밀 정답을 하나 골랐습니다...";
    }
}
