package baseballgame.application.domain;

public class BaseballGame {

    private final Referee referee;
    private final AnswerGenerator answerGenerator;

    public BaseballGame(Referee referee, AnswerGenerator answerGenerator) {
        this.referee = referee;
        this.answerGenerator = answerGenerator;
    }

    public RoundResult judge(UserGuess userGuess) {
        return referee.judge(userGuess);
    }

    public void reset() {
        referee.resetGame(answerGenerator.generate());
    }
}
