package baseballgamev2.domain;

public class PlayResult {

    private static final int GAME_OVER_CONDITION = 3;
    private int ball;
    private int strike;

    private PlayResult() {
        this.ball = 0;
        this.strike = 0;
    }

    static PlayResult without() {
        return new PlayResult();
    }

    void increaseBall() {
        this.ball++;
    }

    void increaseStrike() {
        this.strike++;
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public boolean isNothing() {
        return this.strike + this.ball == 0;
    }

    public boolean isGameOver() {
        return this.strike == GAME_OVER_CONDITION;
    }
}