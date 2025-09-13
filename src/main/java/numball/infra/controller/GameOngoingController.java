package numball.infra.controller;

import textgame.controller.GameController;
import numball.domain.exception.DomainException;
import numball.domain.plate.Plate;
import numball.domain.plate.throwresult.ThrowResult;
import numball.infra.view.GameAnswerToPlayerView;
import numball.infra.view.GameAskForInputView;
import numball.infra.view.GameDomainExceptionView;
import textgame.view.GameView;
import textgame.view.JointGameView;

public class GameOngoingController implements GameController {
    private final Plate computerPlate;
    private final GameView preview;

    public GameOngoingController(Plate computerPlate, GameView preview) {
        this.computerPlate = computerPlate;
        this.preview = preview;
    }

    @Override
    public GameView getPreview() {
        return preview;
    }

    @Override
    public GameController doActionWithPlayerInput(String userInput) {
        try {
            if (userInput.equals("000"))
                return playerLost();

            Plate playerAskingPlate = Plate.from(userInput);
            ThrowResult result = computerPlate.questionWith(playerAskingPlate);

            if (result.isGameWin())
                return playerWon();

            return gameContinues(result);

        } catch (DomainException e) {
            return gameErrorsButContinues(e);
        }
    }

    private GameLoseController playerLost() {
        return new GameLoseController(computerPlate);
    }

    private GameWinController playerWon() {
        return new GameWinController();
    }

    private GameOngoingController gameContinues(ThrowResult result) {
        return new GameOngoingController(
                computerPlate,
                new JointGameView(
                        new GameAnswerToPlayerView(result),
                        new GameAskForInputView()
                )
        );
    }

    private GameOngoingController gameErrorsButContinues(DomainException ex) {
        return new GameOngoingController(
                computerPlate,
                new JointGameView(
                        new GameDomainExceptionView(ex),
                        new GameAskForInputView()
                )
        );
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
