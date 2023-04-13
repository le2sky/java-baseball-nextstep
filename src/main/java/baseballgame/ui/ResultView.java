package baseballgame.ui;

import baseballgame.application.api.GuessNumberResponse;

public class ResultView {

    public static void renderResult(GuessNumberResponse response) {
        if (response.getBall() + response.getStrike() == 0) {
            System.out.println("낫싱");
        }
        System.out.println(buildMessageWithMatchCount(response.getStrike(), "스트라이크 ")
            + buildMessageWithMatchCount(response.getBall(), "볼").trim());
    }

    private static String buildMessageWithMatchCount(int count, String postfix) {
        if (count == 0) {
            return "";
        }
        return count + postfix;
    }
}
