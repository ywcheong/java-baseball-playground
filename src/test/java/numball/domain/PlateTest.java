package numball.domain;

import numball.domain.exception.DuplicativePlateValueException;
import numball.domain.exception.PlateSizeException;
import numball.domain.plate.Plate;
import numball.domain.plate.throwresult.ThrowResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlateTest {
    @Test
    @DisplayName("플레이트를 생성할 수 있다")
    void canMakePlate() {
        // given - when - then
        Plate.from("123");
    }

    @Test
    @DisplayName("중복된 숫자로는 플레이트를 생성할 수 없다")
    void cannotMakeDupPlate() {
        // given - when - then
        Assertions.assertThrows(DuplicativePlateValueException.class, () -> Plate.from("113"));
    }

    @Test
    @DisplayName("잘못된 길이의 플레이트를 생성할 수 없다")
    void cannotMakeWeirdSizePlate() {
        // given - when - then
        Assertions.assertThrows(PlateSizeException.class, () -> Plate.from("1234"));
    }

    @Test
    @DisplayName("플레이트를 비교했을 때 볼이 계산된다")
    void ballOk() {
        // given
        Plate answer = Plate.from("123");
        Plate question = Plate.from("289");

        // when
        ThrowResult result = answer.questionWith(question);

        // then
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(1);
        assertThat(result.isGameWin()).isFalse();
    }

    @Test
    @DisplayName("플레이트를 비교했을 때 스트라이크가 계산된다")
    void strikeOk() {
        // given
        Plate answer = Plate.from("123");
        Plate question = Plate.from("189");

        // when
        ThrowResult result = answer.questionWith(question);

        // then
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.isGameWin()).isFalse();
    }

    @Test
    @DisplayName("플레이트를 비교했을 때 스트라이크와 볼이 계산된다")
    void strikeAndBallOk() {
        // given
        Plate answer = Plate.from("123");
        Plate question = Plate.from("139");

        // when
        ThrowResult result = answer.questionWith(question);

        // then
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(1);
        assertThat(result.isGameWin()).isFalse();
    }

    @Test
    @DisplayName("플레이트가 일치하면 승리한다")
    void threeStrikeOk() {
        // given
        Plate answer = Plate.from("123");
        Plate question = Plate.from("123");

        // when
        ThrowResult result = answer.questionWith(question);

        // then
        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.isGameWin()).isTrue();
    }

    @Test
    @DisplayName("플레이트를 비교했을 때 아웃이 계산된다")
    void outOk() {
        // given
        Plate answer = Plate.from("123");
        Plate question = Plate.from("789");

        // when
        ThrowResult result = answer.questionWith(question);

        // then
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(0);
        assertThat(result.isGameWin()).isFalse();
    }
}
