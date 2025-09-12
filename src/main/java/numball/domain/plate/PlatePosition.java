package numball.domain.plate;

public class PlatePosition {
    private final int value;

    public PlatePosition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof PlatePosition)) return false;
        return this.value == ((PlatePosition) obj).value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
