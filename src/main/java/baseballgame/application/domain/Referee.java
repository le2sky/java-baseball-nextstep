package baseballgame.application.domain;

public class Referee {

    private Answer answer;

    public Referee(Answer answer) {
        this.answer = answer;
    }

    public void resetGame(Answer answer) {
        this.answer = answer;
    }

    public RoundResult judge(UserGuess userGuess) {
        return new RoundResult(getStrike(userGuess), getBall(userGuess));
    }

    private int getBall(UserGuess userGuess) {
        String target = userGuess.getGuess();
        int ball = 0;
        for (int i = 0; i < target.length(); i++) {
            String ch = String.valueOf(target.charAt(i));
            if (answer.contain(ch)) {
                ball++;
            }
        }
        return ball;
    }

    private int getStrike(UserGuess userGuess) {
        String target = userGuess.getGuess();
        int strike = 0;
        for (int i = 0; i < target.length(); i++) {
            if (answer.indexOf(target.charAt(i), i)) {
                strike++;
            }
        }
        return strike;
    }
}
