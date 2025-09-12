package numball.domain.plate;

public class PlateValue {
    private final char value;

    public PlateValue(char value) {
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
