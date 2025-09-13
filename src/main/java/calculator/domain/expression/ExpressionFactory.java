package calculator.domain.expression;

import calculator.domain.exception.EmptyExpressionException;
import calculator.domain.exception.MalformedExpressionException;
import calculator.domain.expression.impl.IntermediateExpression;
import calculator.domain.expression.impl.TerminalExpression;
import calculator.domain.number.Number;
import calculator.domain.number.NumberFactory;
import calculator.domain.operator.BinaryOperator;
import calculator.domain.operator.OperatorFactory;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ExpressionFactory {
    // 원시 String을 받아서, Expression으로 변환
    // 내부적으로 StringTokenizer로 변환해서 private 함수 호출하는 구조임
    public static Expression from(String stringExpression) {
        StringTokenizer tokenizer = new StringTokenizer(stringExpression);

        if (!tokenizer.hasMoreTokens()) throw new EmptyExpressionException();
        Number startingNumber = NumberFactory.from(tokenizer.nextToken());
        Expression startingNumberAsExpression = new TerminalExpression(startingNumber);

        return ExpressionFactory.from(startingNumberAsExpression, tokenizer);
    }

    private static Expression from(Expression leadingExpression, StringTokenizer tokenizer) {
        // Expression은 인터페이스이므로
        // TerminalExpression || IntermediateExpression 두 구현체 중 하나로 반환됨
        try {
            if (!tokenizer.hasMoreElements()) {
                return leadingExpression;
            }

            BinaryOperator operator = OperatorFactory.from(tokenizer.nextToken());
            Number nextNumber = NumberFactory.from(tokenizer.nextToken());

            Expression expandedLeadingExpression = new IntermediateExpression(leadingExpression, operator, nextNumber);
            return ExpressionFactory.from(expandedLeadingExpression, tokenizer);

        } catch (NoSuchElementException e) {
            throw new MalformedExpressionException();
        }
    }
}
