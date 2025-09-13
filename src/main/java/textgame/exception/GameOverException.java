package textgame.exception;

public class GameOverException extends RuntimeException {
    public GameOverException() {
        super("게임이 이미 종료되었습니다!");
    }
}
