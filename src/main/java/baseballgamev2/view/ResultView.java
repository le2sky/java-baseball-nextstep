package baseballgamev2.view;

import baseballgamev2.domain.PlayResult;

public class ResultView {

    private static final String WRITE_STRIKE_FORMAT = "%d스트라이크";
    private static final String WRITE_BALL_FORMAT = "%d볼";
    private static final String WRITE_NOTHING_MESSAGE = "낫싱";
    private static final String WRITE_GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void writeResult(PlayResult result) {
        if (result.isNothing()) {
            System.out.println(WRITE_NOTHING_MESSAGE);
            return;
        }

        System.out.println(buildResultMessage(result));
    }

    private StringBuilder buildResultMessage(PlayResult result) {
        StringBuilder message = new StringBuilder();
        appendBallMessage(result, message);
        appendStrikeMessage(result, message);
        return message;
    }

    private void appendStrikeMessage(PlayResult result, StringBuilder stringBuilder) {
        int strike = result.getStrike();
        if (strike == 0) {
            return;
        }
        stringBuilder.append(String.format(WRITE_STRIKE_FORMAT, strike));
    }

    private void appendBallMessage(PlayResult result, StringBuilder stringBuilder) {
        int ball = result.getBall();
        if (ball == 0) {
            return;
        }
        stringBuilder.append(String.format(WRITE_BALL_FORMAT, ball));
    }
}