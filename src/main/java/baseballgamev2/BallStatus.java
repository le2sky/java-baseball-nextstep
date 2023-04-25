package baseballgamev2;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isStrike() {
        return this == BallStatus.STRIKE;
    }

    public boolean isBall() {
        return this == BallStatus.BALL;
    }

    public boolean isNothing() {
        return this == BallStatus.NOTHING;
    }
}
