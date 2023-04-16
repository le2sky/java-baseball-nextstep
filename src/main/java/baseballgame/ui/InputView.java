package baseballgame.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputView {

    private static final BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(System.in));

    public static String readUserGuess() {
        System.out.print("숫자를 입력해 주세요 : ");
        try {
            return bufferedReader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String readRestartCommand() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            return bufferedReader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
