package calculator.domain.exception;

public class InvalidOperatorException extends RuntimeException {
    public InvalidOperatorException(String message) {
        super("'" + message + "'는 잘못된 연산자입니다. (유효한 연산자는 +, -, *, /입니다)");
    }
}
