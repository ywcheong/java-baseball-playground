package numball.infra.view;

import textgame.view.GameView;

public class GameAskForInputView implements GameView {
    @Override
    public String render() {
        return "컴퓨터에게 숫자 3자리를 물어보세요: ";
    }
}
