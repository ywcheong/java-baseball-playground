package numball.domain.plate;

import numball.domain.exception.DuplicativePlateValueException;
import numball.domain.plate.throwresult.SingleThrowResult;
import numball.domain.plate.throwresult.ThrowResult;
import numball.domain.exception.PlateSizeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Plate {
    // 숫자야구 게임의 플레이트 사이즈 (예: 3이면 "XXX")
    public static final int PLATE_SIZE = 3;
    private final Map<PlatePosition, PlateValue> elements;

    public Plate(Map<PlatePosition, PlateValue> elements) {
        if (elements.size() != PLATE_SIZE) throw new PlateSizeException();
        if (elements.values().stream().distinct().count() != PLATE_SIZE) throw new DuplicativePlateValueException();
        this.elements = elements;
    }

    public static Plate from(String plateString) {
        Map<PlatePosition, PlateValue> elements = new HashMap<>();

        for (int pos = 0; pos < plateString.length(); pos++) {
            PlatePosition platePosition = new PlatePosition(pos);
            PlateValue plateValue = new PlateValue(plateString.charAt(pos));
            elements.put(platePosition, plateValue);
        }

        return new Plate(elements);
    }

    private Set<PlatePosition> getPositions() {
        return elements.keySet();
    }

    /**
     * 정답 플레이트에게 묻습니다: 이 질문 플레이트를 던지면, 결과는 무엇입니까?
     *
     * @param question 질문 플레이트
     * @return ThrowResult
     */
    public ThrowResult questionWith(Plate question) {
        // 답에게 질문하기 == 질문에 답하기 (조금 난해하지만 자명함)
        Plate answer = this;
        return question.answerWith(answer);
    }

    /**
     * 질문 플레이트가 묻습니다: 이 정답 플레이트라면, 결과는 무엇입니까?
     *
     * @param answer 정답 플레이트
     * @return ThrowResult
     */
    public ThrowResult answerWith(Plate answer) {
        ThrowResult result = new ThrowResult(0, 0);

        for (PlatePosition questionPos : getPositions()) {
            PlateValue questionValue = elements.get(questionPos);
            SingleThrowResult singleThrowResult = answer.questionWith(questionPos, questionValue);
            result = result.add(singleThrowResult);
        }

        return result;
    }

    /**
     * 정답 플레이트에게 묻습니다: pos 자리에 추측 value를 던지면, (스트라이크 / 볼 / 아무것도 아님) 중 무엇입니까?
     *
     * @param questionPos   pos 자리
     * @param questionValue value
     * @return SingleThrowResult
     */
    private SingleThrowResult questionWith(PlatePosition questionPos, PlateValue questionValue) {
        if (questionValue.equals(elements.get(questionPos))) return SingleThrowResult.STRIKE;
        if (elements.containsValue(questionValue)) return SingleThrowResult.BALL;
        return SingleThrowResult.NOTHING;
    }
}
