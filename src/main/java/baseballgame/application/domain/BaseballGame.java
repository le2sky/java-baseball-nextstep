package baseballgame.application.domain;

public class BaseballGame {

    private String answer;

    public BaseballGame(String answer) {
        this.answer = answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String judge(UserGuess userGuess) {
        RoundResult roundResult = new RoundResult(getStrike(userGuess), getBall(userGuess));
        if (roundResult.isNothing()) {
            return "낫싱";
        }

        return buildMessage(roundResult);
    }

    private String buildMessage(RoundResult roundResult) {
        String strikeString = buildMessageWithMatchCount(roundResult.getStrike(), "스트라이크 ");
        String ballString = buildMessageWithMatchCount(roundResult.getBall(), "볼");
        return (strikeString + ballString).trim();
    }

    private String buildMessageWithMatchCount(int count, String postfix) {
        if (count == 0) {
            return "";
        }
        return count + postfix;
    }

    private int getBall(UserGuess userGuess) {
        String target = userGuess.getGuess();
        int ball = 0;
        for (int i = 0; i < target.length(); i++) {
            String ch = String.valueOf(target.charAt(i));
            if (answer.contains(ch)) {
                ball++;
            }
        }
        return ball;
    }

    private int getStrike(UserGuess userGuess) {
        String target = userGuess.getGuess();
        int strike = 0;
        for (int i = 0; i < target.length(); i++) {
            if (isStrike(target.charAt(i), i)) {
                strike++;
            }
        }
        return strike;
    }

    private boolean isStrike(char target, int targetIndex) {
        return answer.indexOf(target) == targetIndex;
    }
}
