package numball.infra.controller;

import textgame.controller.GameController;
import numball.infra.view.GameWinView;
import textgame.view.GameView;

public class GameWinController implements GameController {
    private final GameView preview;

    public GameWinController() {
        this.preview = new GameWinView();
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
