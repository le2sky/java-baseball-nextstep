package baseballgamev2.domain;

enum BallStatus {

    BALL, STRIKE, NOTHING;

    boolean isStrike() {
        return this == BallStatus.STRIKE;
    }

    boolean isBall() {
        return this == BallStatus.BALL;
    }

    boolean isNothing() {
        return this == BallStatus.NOTHING;
    }
}