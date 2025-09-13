package calculator.domain.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberFactoryTest {
    @Test
    @DisplayName("숫자를 생성한다")
    void newNumber() {
        Number number = NumberFactory.from("3");

        assertThat(number.getValue()).isEqualTo(3);
    }

    @Test
    @DisplayName("여러 자리의 숫자를 생성한다")
    void newLongNumber() {
        Number number = NumberFactory.from("34");

        assertThat(number.getValue()).isEqualTo(34);
    }

    @Test
    @DisplayName("숫자가 아니면 생성하지 않는다")
    void notANumberException() {
        Assertions.assertThrows(RuntimeException.class, () -> NumberFactory.from("3a"));
    }
}