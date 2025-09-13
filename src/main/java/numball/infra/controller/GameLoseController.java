package numball.infra.controller;

import textgame.controller.GameController;
import numball.domain.plate.Plate;
import numball.infra.view.GameLoseView;
import textgame.view.GameView;

public class GameLoseController implements GameController {
    private final GameView preview;

    public GameLoseController(Plate computerPlate) {
        this.preview = new GameLoseView(computerPlate);
    }

    @Override
    public GameView getPreview() {
        return preview;
    }

    @Override
    public GameController doActionWithPlayerInput(String userInput) {
        return null;
    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
