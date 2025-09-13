package calculator.domain.operator;

import calculator.domain.number.Number;

public abstract class BinaryOperator {
    public abstract Number operate(Number left, Number right);
}
