package baseballgame.application.api;

public class GuessNumberResponse {
    private final int ball;
    private final int strike;

    public GuessNumberResponse(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
