package calculator.domain.operator.impl;

import calculator.domain.number.Number;
import calculator.domain.operator.BinaryOperator;

public class MultiplicationOperator extends BinaryOperator {
    @Override
    public Number operate(Number left, Number right) {
        int result = left.getValue() * right.getValue();
        return new Number(result);
    }
}