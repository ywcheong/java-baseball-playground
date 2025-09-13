package calculator.domain.expression;

/*
    Expression은 다음 두 가지 형태로 존재할 수 있다.

    - Number
        - 이를 TerminalExpression (끝식)이라고 하자. (cons list와 같은 구조)
    - Expression, BinaryOperator, Number
        - 이를 IntermediateExpression (중간식)이라고 하자.

    또한 Expression은 계산할 수 있다. 이 행동을 .compute()라 두자.
*/

import calculator.domain.number.Number;

public abstract class Expression {
    public abstract Number compute();
}
