package numball.infra.view;

import numball.domain.plate.Plate;
import textgame.view.GameView;

public class GameLoseView implements GameView {
    private final Plate computerPlate;

    public GameLoseView(Plate computerPlate) {
        this.computerPlate = computerPlate;
    }

    @Override
    public String render() {
        return "패배했습니다! (정답: " + computerPlate.toString() + ")";
    }
}
