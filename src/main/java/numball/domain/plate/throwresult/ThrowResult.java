package numball.domain.plate.throwresult;

import numball.domain.plate.Plate;

public class ThrowResult {

    private final int strikeCount;
    private final int ballCount;

    public ThrowResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public ThrowResult add(SingleThrowResult singleThrow) {
        if (singleThrow == SingleThrowResult.STRIKE)
            return new ThrowResult(strikeCount + 1, ballCount);
        if (singleThrow == SingleThrowResult.BALL)
            return new ThrowResult(strikeCount, ballCount + 1);
        return this;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isGameWin() {
        return strikeCount == Plate.PLATE_SIZE;
    }
}
