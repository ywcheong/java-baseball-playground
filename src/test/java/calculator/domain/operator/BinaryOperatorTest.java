package calculator.domain.operator;

import calculator.domain.number.Number;
import calculator.domain.number.NumberFactory;
import calculator.domain.operator.impl.AdditionOperator;
import calculator.domain.operator.impl.DivisionOperator;
import calculator.domain.operator.impl.MultiplicationOperator;
import calculator.domain.operator.impl.SubstractionOperator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinaryOperatorTest {

    Number two;
    Number three;
    Number six;

    @BeforeEach
    void setUp() {
        // arrange
        two = NumberFactory.from("2");
        three = NumberFactory.from("3");
        six = NumberFactory.from("6");
    }

    @Test
    @DisplayName("덧셈이 올바르다")
    void addTest() {
        BinaryOperator operator = new AdditionOperator();

        Number five = operator.operate(two, three);

        Assertions.assertThat(five.getValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈이 올바르다")
    void subTest() {
        BinaryOperator operator = new SubstractionOperator();

        Number minusOne = operator.operate(two, three);

        Assertions.assertThat(minusOne.getValue()).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈이 올바르다")
    void mulTest() {
        BinaryOperator operator = new MultiplicationOperator();

        Number six = operator.operate(two, three);

        Assertions.assertThat(six.getValue()).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈이 올바르다")
    void divTest() {
        BinaryOperator operator = new DivisionOperator();

        Number twoComputed = operator.operate(six, three);

        Assertions.assertThat(twoComputed.getValue()).isEqualTo(2);
    }
}