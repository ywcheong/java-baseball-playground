package textgame.exception;

public class GameNotOverException extends RuntimeException {
    public GameNotOverException() {
        super("게임이 종료되지 않았습니다!");
    }
}
