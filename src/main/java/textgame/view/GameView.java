package textgame.view;

/**
 * 게임 화면을 표현하는 뷰(View) 역할을 하는 인터페이스입니다.
 *
 * <p>{@link #render()} 메서드를 통해 게임의 현재 상태를 문자열 형태로 렌더링합니다.</p>
 */
public interface GameView {
    String render();
}
