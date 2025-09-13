package numball.infra.view;

import numball.domain.plate.throwresult.ThrowResult;
import textgame.view.GameView;

public class GameAnswerToPlayerView implements GameView {
    private final ThrowResult result;

    public GameAnswerToPlayerView(ThrowResult result) {
        this.result = result;
    }

    @Override
    public String render() {
        return result.getStrikeCount() + " 스트라이크, " + result.getBallCount() + " 볼입니다!";
    }
}
