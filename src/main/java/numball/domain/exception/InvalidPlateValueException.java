package numball.domain.exception;

public class InvalidPlateValueException extends DomainException {
    public InvalidPlateValueException() {
        super("플레이트에 사용할 수 없는 문자가 있습니다.");
    }
}
