package numball.domain.plate.throwresult;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ThrowResultTest {
    private ThrowResult result;

    @BeforeEach
    void beforeEach() {
        // given
        result = new ThrowResult(0, 0);
    }

    @Test
    @DisplayName("스트라이크를 추가할 수 있다")
    void canAddStrike() {
        // given
        SingleThrowResult singleThrowResult = SingleThrowResult.STRIKE;

        // when
        ThrowResult newResult = result.add(singleThrowResult);

        // then
        assertThat(newResult.getStrikeCount()).isEqualTo(1);
        assertThat(newResult.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("볼을 추가할 수 있다")
    void canAddBall() {
        // given
        SingleThrowResult singleThrowResult = SingleThrowResult.BALL;

        // when
        ThrowResult newResult = result.add(singleThrowResult);

        // then
        assertThat(newResult.getStrikeCount()).isEqualTo(0);
        assertThat(newResult.getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("아무것도 아님을 추가할 수 있다")
    void canAddNothing() {
        // given
        SingleThrowResult singleThrowResult = SingleThrowResult.NOTHING;

        // when
        ThrowResult newResult = result.add(singleThrowResult);

        // then
        assertThat(newResult.getStrikeCount()).isEqualTo(0);
        assertThat(newResult.getBallCount()).isEqualTo(0);
    }
}