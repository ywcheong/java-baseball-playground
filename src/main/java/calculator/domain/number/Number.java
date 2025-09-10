package calculator.domain.number;

/*
    편의상 모든 입력을 정수로 가정하고, 나눗셈 연산도 정수몫 연산으로 처리하자.
    사실 실수형 자료를 사용해도 문제는 없지만 테스트를 작성하기 번거롭고 Toy 시스템이니 생략한다.
*/

public class Number {
    int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
