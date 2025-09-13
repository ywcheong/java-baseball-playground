package numball.infra.view;

import numball.domain.exception.DomainException;
import textgame.view.GameView;

public class GameDomainExceptionView implements GameView {
    private final DomainException ex;

    public GameDomainExceptionView(DomainException ex) {
        this.ex = ex;
    }

    @Override
    public String render() {
        return "오류! " + ex.getMessage();
    }
}
