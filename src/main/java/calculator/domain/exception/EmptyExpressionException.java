package calculator.domain.exception;

public class EmptyExpressionException extends RuntimeException {
    public EmptyExpressionException() {
        super("빈 식은 계산할 수 없습니다.");
    }
}