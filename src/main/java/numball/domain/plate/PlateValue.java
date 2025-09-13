package numball.domain.plate;

import numball.domain.exception.InvalidPlateValueException;

import java.util.HashSet;
import java.util.Set;

public class PlateValue {
    public static final Set<Character> ACCEPTABLE_VALUES = new HashSet<>(Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9'));
    private final char value;

    public PlateValue(char value) {
        if (!ACCEPTABLE_VALUES.contains(value))
            throw new InvalidPlateValueException();
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof PlateValue)) return false;
        return this.value == ((PlateValue) obj).value;
    }

    @Override
    public int hashCode() {
        return Character.hashCode(value);
    }
}
