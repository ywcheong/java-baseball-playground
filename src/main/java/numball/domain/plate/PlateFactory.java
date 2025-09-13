package numball.domain.plate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PlateFactory {
    public static Plate createRandomPlate() {
        // 깊은 복사 필수임에 주의!!
        List<Character> candidates = new ArrayList<>(PlateValue.ACCEPTABLE_VALUES);
        Collections.shuffle(candidates);

        String plateString = candidates.stream()
                .limit(Plate.PLATE_SIZE)
                .map(String::valueOf)
                .collect(Collectors.joining(""));

        return Plate.from(plateString);
    }
}
