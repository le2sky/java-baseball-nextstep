package baseballgame.application.domain;

class RoundResult {

    private final int strike;
    private final int ball;

    public RoundResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball - strike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
