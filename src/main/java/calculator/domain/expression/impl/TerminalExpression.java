package calculator.domain.expression.impl;

import calculator.domain.expression.Expression;
import calculator.domain.number.Number;

public class TerminalExpression extends Expression {
    Number number;

    public TerminalExpression(Number number) {
        this.number = number;
    }

    @Override
    public Number compute() {
        return this.number;
    }
}
