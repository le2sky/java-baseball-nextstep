package baseballgamev2;

public class PlayResult {

    public final int GAME_OVER_CONDITION = 3;
    private int ball;
    private int strike;

    public PlayResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public void increaseBall() {
        this.ball++;
    }

    public void increaseStrike() {
        this.strike++;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isGameOver() {
        return this.strike == GAME_OVER_CONDITION;
    }
}