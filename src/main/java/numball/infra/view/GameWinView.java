package numball.infra.view;

import textgame.view.GameView;

public class GameWinView implements GameView {
    @Override
    public String render() {
        return "축하합니다! 정답입니다.";
    }
}
