package textgame;

import textgame.controller.GameController;
import textgame.exception.GameNotOverException;
import textgame.exception.GameOverException;

import java.io.*;

/**
 * 게임의 전체 실행 주기를 관리하는 클래스입니다.
 *
 * <p>이 클래스는 {@link GameController}를 통해 게임의 상태 전환과
 * 출력을 제어하며, 플레이어 입력을 받아 컨트롤러에 전달합니다.</p>
 *
 * <p>게임 실행 예시:</p>
 * <pre>{@code
 * GameController welcomeController = ...;
 * TextGame game = new TextGame(welcomeController);
 *
 * while (!game.isGameOver()) {
 *     game.doGameStep();
 * }
 *
 * game.showGameOver();
 * }</pre>
 */
public class TextGame {
    private GameController currentController;
    private final BufferedReader userInputReader;
    private final BufferedWriter gameOutputWriter;

    public TextGame(GameController currentController, BufferedReader userInputReader, BufferedWriter gameOutputWriter) {
        this.currentController = currentController;
        this.userInputReader = userInputReader;
        this.gameOutputWriter = gameOutputWriter;
    }

    /**
     * 실제 게임 단계를 수행합니다. {@link #isGameOver()}가 {@code true}라면 {@link GameOverException}이 발생합니다.
     * @throws IOException 입출력 중 오류
     * @throws GameOverException 게임이 이미 종료됨
     */
    public synchronized void doGameStep() throws IOException {
        if (isGameOver())
            throw new GameOverException();

        // 플레이어에게 현재 View를 표시
        renderViewAndFlush();

        // View를 본 플레이어는 입력을 결정
        String playerInput = getPlayerInput();

        // 플레이어의 입력을 컨트롤러로 전달
        // 내부 컨트롤러를 업데이트해 다음 doGameStep 대기
        currentController = currentController.doActionWithPlayerInput(playerInput);
    }

    /**
     * 현재 View를 렌더한 뒤 {@link #gameOutputWriter}로 출력합니다.
     * @throws IOException 출력 중 오류가 발생
     */
    private synchronized void renderViewAndFlush() throws IOException {
        String renderedString = currentController.getPreview().render();
        gameOutputWriter.write(renderedString);
        gameOutputWriter.flush();
    }

    /**
     * @return 게임 종료 여부
     */
    public synchronized boolean isGameOver() {
        return currentController.isGameOver();
    }

    /**
     * 게임이 종료되었을 때 게임 종료 View를 렌더한 뒤 {@link #gameOutputWriter}로 렌더된 화면을 출력합니다.
     * 게임이 종료되지 않았다면 {@link textgame.exception.GameNotOverException}이 발생합니다.
     * @throws IOException 출력 중 오류 발생
     * @throws GameNotOverException 게임이 아직 종료되지 않음
     */
    public synchronized void showGameOver() throws IOException {
        if (!isGameOver())
            throw new GameNotOverException();
        renderViewAndFlush();
    }

    /**
     * 플레이어 입력을 한 줄 읽어 반환합니다.
     *
     * @return 플레이어의 입력 문자열
     */
    private synchronized String getPlayerInput() throws IOException {
        return userInputReader.readLine();
    }
}