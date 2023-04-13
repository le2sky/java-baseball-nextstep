package baseballgame.application.domain;

public class BaseballGame {

    private final Referee referee;

    public BaseballGame(Referee referee) {
        this.referee = referee;
    }

    public RoundResult judge(UserGuess userGuess) {
        return referee.judge(userGuess);
    }
}
