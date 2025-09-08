package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /*
        요구사항 1
        - "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        - "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @Test
    void splitTwo() {
        // arrange & act
        String[] split = "1,2".split(",");

        // assert
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    void splitOne() {
        // arrange & act
        String[] split = "1".split(",");

        // assert
        assertThat(split).containsExactly("1");
    }

    /*
        요구사항 2
        - "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    void subString() {
        // arrange
        String original = "(1,2)";

        // act
        String substr = original.substring(1, 4);

        // assert
        assertThat(substr).isEqualTo("1,2");
    }

    /*
        요구사항 3
        - "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        - JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     */
    @DisplayName("charAt으로 문자열의 특정 인덱스에 해당하는 문자를 얻는다")
    @Test
    void charAtSuccessTest() {
        // arrange
        String original = "abc";

        // act
        char indexOneChar = original.charAt(1);

        // assert
        assertThat(indexOneChar).isEqualTo('b');
    }

    @DisplayName("charAt의 인덱스가 문자열 범위를 이탈하면 오류가 발생한다")
    @Test
    void charAtOutOfRangeTest() {
        // arrange
        String original = "abc";

        // act & assert
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            original.charAt(99);
        });
    }
}
