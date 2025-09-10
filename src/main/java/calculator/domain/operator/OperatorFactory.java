package calculator.domain.operator;

import calculator.domain.exception.InvalidOperatorException;
import calculator.domain.operator.impl.AdditionOperator;
import calculator.domain.operator.impl.DivisionOperator;
import calculator.domain.operator.impl.MultiplicationOperator;
import calculator.domain.operator.impl.SubstractionOperator;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    static Map<String, BinaryOperator> operatorDictionary;

    static {
        operatorDictionary = new HashMap<>();
        operatorDictionary.put("+", new AdditionOperator());
        operatorDictionary.put("-", new SubstractionOperator());
        operatorDictionary.put("*", new MultiplicationOperator());
        operatorDictionary.put("/", new DivisionOperator());
    }

    public static BinaryOperator from(String rawOperatorString) {
        BinaryOperator operator = operatorDictionary.get(rawOperatorString);
        if (operator == null) throw new InvalidOperatorException(rawOperatorString);
        return operator;
    }
}
