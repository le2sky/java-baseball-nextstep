package baseballgamev2.domain;

public class PlayResult {

    private static final int GAME_OVER_CONDITION = 3;
    private int ball;
    private int strike;

    private PlayResult() {
        this.ball = 0;
        this.strike = 0;
    }

    public static PlayResult without() {
        return new PlayResult();
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