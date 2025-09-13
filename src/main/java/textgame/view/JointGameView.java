package textgame.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 여러 {@link GameView}를 결합해서 보여주고 싶을 때 간단히 사용합니다.
 *
 * <pre>{@code
 * GameView jointView = new JointGameView(
 *      new GameViewTypeA(), new GameViewTypeB(), ...
 * );
 * }</pre>
 */
public class JointGameView implements GameView {
    private final List<GameView> views;

    public JointGameView(GameView... views) {
        this.views = Arrays.asList(views);
    }

    @Override
    public String render() {
        return views.stream()
                .map(GameView::render)
                .collect(Collectors.joining("\n"));
    }
}
