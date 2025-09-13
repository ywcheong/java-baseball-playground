package calculator.domain.exception;

public class MalformedExpressionException extends RuntimeException {
    public MalformedExpressionException() {
        super("계산할 수 없는 식입니다.");
    }
}