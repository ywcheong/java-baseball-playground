package calculator.domain.expression.impl;

import calculator.domain.expression.Expression;
import calculator.domain.number.Number;
import calculator.domain.operator.BinaryOperator;

public class IntermediateExpression extends Expression {
    Expression expression;
    BinaryOperator binaryOperator;
    Number number;

    public IntermediateExpression(Expression expression, BinaryOperator binaryOperator, Number number) {
        this.expression = expression;
        this.binaryOperator = binaryOperator;
        this.number = number;
    }

    @Override
    public Number compute() {
        Number left = this.expression.compute();
        Number right = this.number;
        return binaryOperator.operate(left, right);
    }
}
