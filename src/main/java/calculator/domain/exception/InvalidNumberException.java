package calculator.domain.exception;

public class InvalidNumberException extends RuntimeException {
    public InvalidNumberException(String message) {
        super("'" + message + "'는 잘못된 숫자입니다. (유효한 연산자는 +, -, *, /입니다)");
    }
}