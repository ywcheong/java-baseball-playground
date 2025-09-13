package numball;

import numball.infra.controller.GameWelcomeController;
import textgame.controller.GameController;
import textgame.TextGame;

import java.io.*;

public class NumballGame {
    public static void main(String[] args) throws IOException {
        GameController welcomeController = new GameWelcomeController();
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter gameOutputWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        TextGame game = new TextGame(welcomeController, userInputReader, gameOutputWriter);

        while (!game.isGameOver()) {
            game.doGameStep();
        }

        game.showGameOver();
    }
}