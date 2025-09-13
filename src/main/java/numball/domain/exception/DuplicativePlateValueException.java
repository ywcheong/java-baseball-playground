package numball.domain.exception;

public class DuplicativePlateValueException extends DomainException {
    public DuplicativePlateValueException() {
        super("중복된 플레이트 값이 있습니다.");
    }
}
