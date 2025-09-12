package numball.domain.exception;

public class PlateSizeException extends DomainException {
    public PlateSizeException() {
        super("잘못된 플레이트 크기입니다.");
    }
}
