package numball.infra.controller;

import textgame.controller.GameController;
import numball.domain.plate.Plate;
import numball.domain.plate.PlateFactory;
import numball.infra.view.GameAskForInputView;
import numball.infra.view.GameDecideAnswerView;
import numball.infra.view.GameWelcomesView;
import textgame.view.GameView;
import textgame.view.JointGameView;

public class GameWelcomeController implements GameController {
    private final GameView preview;

    public GameWelcomeController() {
        this.preview = new GameWelcomesView();
    }

    @Override
    public GameView getPreview() {
        return preview;
    }

    @Override
    public GameController doActionWithPlayerInput(String userInput) {
        Plate computerPlate = PlateFactory.createRandomPlate();

        return new GameOngoingController(
                computerPlate,
                new JointGameView(
                        new GameDecideAnswerView(),
                        new GameAskForInputView()
                )
        );
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
