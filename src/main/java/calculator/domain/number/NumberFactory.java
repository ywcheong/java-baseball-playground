package calculator.domain.number;

import calculator.domain.exception.InvalidNumberException;

public class NumberFactory {
    public static Number from(String rawNumberString) {
        try {
            int value = Integer.parseInt(rawNumberString);
            return new Number(value);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException(rawNumberString);
        }
    }
}
