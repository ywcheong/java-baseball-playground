package calculator.domain.expression;

import calculator.domain.exception.EmptyExpressionException;
import calculator.domain.number.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExpressionFactoryTest {
    @Test
    @DisplayName("두 숫자로 이루어진 식을 계산한다")
    void twoNumberSuccess() {
        // arrange
        Expression expression = ExpressionFactory.from("1 + 2");

        // act
        Number result = expression.compute();

        // assert
        assertThat(result.getValue()).isEqualTo(3);
    }

    @Test
    @DisplayName("앞에서부터 순서대로 계산한다")
    void computeWithOrder() {
        // arrange
        Expression expression = ExpressionFactory.from("1 + 2 * 3");

        // act
        Number result = expression.compute();

        // assert
        assertThat(result.getValue()).isEqualTo(9);
    }

    @Test
    @DisplayName("빈 식은 오류이다")
    void emptyExpressionThrows() {
        // assert
        assertThrows(EmptyExpressionException.class, () -> ExpressionFactory.from(""));
    }

    @Test
    @DisplayName("연속된 숫자는 오류이다")
    void consecutiveNumberThrows() {
        // assert
        assertThrows(RuntimeException.class, () -> ExpressionFactory.from("1 + 2 2 3"));
    }

    @Test
    @DisplayName("연속된 연산자는 오류이다")
    void consecutiveOperatorThrows() {
        // assert
        assertThrows(RuntimeException.class, () -> ExpressionFactory.from("1 + - 2 3"));
    }

    @Test
    @DisplayName("연산자로 끝나는 식은 오류이다")
    void endWithOperatorThrows() {
        // assert
        assertThrows(RuntimeException.class, () -> ExpressionFactory.from("1 + 2 -"));
    }

    @Test
    @DisplayName("연산자로 시작하는 식은 오류이다")
    void startWithOperatorThrows() {
        // assert
        assertThrows(RuntimeException.class, () -> ExpressionFactory.from("+ 2 - 3"));
    }
}