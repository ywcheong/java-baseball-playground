package textgame.controller;

import textgame.view.GameView;

/**
 * 게임의 진행 흐름을 제어하는 컨트롤러 인터페이스입니다.
 *
 * <p>이 인터페이스를 구현한 클래스는 플레이어 입력을 받아
 * 게임 로직을 실행하고, 현재 상태를 표현할 수 있어야 합니다.</p>
 *
 * <p>주요 동작:</p>
 * <ul>
 *   <li>{@link #getPreview()}
 *       현재 게임 상태를 표현하는 {@link GameView}를 반환합니다.
 *       일반적으로 플레이어에게 요구되는 입력이나 상태를 안내하는 역할을 합니다.
 *       게임 종료 상태에서는 최종 결과가 표시됩니다.</li>
 *
 *   <li>{@link #doActionWithPlayerInput(String)}
 *       플레이어의 입력을 처리하여 게임 로직을 수행합니다.
 *       새로운 {@link GameController}를 반환하며, 이는 게임의 "다음 프레임"을 의미합니다.
 *       시스템은 반환된 컨트롤러를 사용해 다음 상태를 렌더링하고,
 *       이후 입력을 다시 해당 컨트롤러로 전달합니다.</li>
 *
 *   <li>{@link #isGameOver()}
 *       현재 게임이 끝났는지를 반환합니다. 이미 게임이 끝난 상태에서만 true를 반환해야 하며,
 *       이번 {@link #doActionWithPlayerInput(String)}로 게임이 끝나는지의 여부는 이 함수의
 *       반환값에 영향을 주어서는 안 됩니다.</li>
 * </ul>
 */
public interface GameController {
    GameView getPreview();
    GameController doActionWithPlayerInput(String userInput);
    boolean isGameOver();
}
