package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        // arrange
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @DisplayName("집합의 크기를 올바르게 반환한다")
    @Test
    void sizeSuccessTest() {
        int size = numbers.size();

        assertThat(size).isEqualTo(3);
    }

    @DisplayName("삽입한 원소가 존재한다 (@ParameterizedTest 활용)")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsSuccessTest(int eachNumber) {
        assertThat(numbers.contains(eachNumber)).isTrue();
    }

    @DisplayName("삽입한 원소만 존재한다 (@CsvSource 활용)")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsComplexTest(int eachNumber, boolean isExists) {
        assertThat(numbers.contains(eachNumber)).isEqualTo(isExists);
    }
}