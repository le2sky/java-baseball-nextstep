package baseballgame.application.domain;

public class RoundResult {

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
}
