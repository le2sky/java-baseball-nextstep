package baseballgamev2.view;

import java.util.Scanner;

public class InputView {

    private static final String READ_USER_BALLS_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String READ_USER_GAME_COMMAND = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String readBalls() {
        System.out.print(READ_USER_BALLS_MESSAGE);
        return readLineWithOutBlank();
    }

    public String readReplayCommand() {
        System.out.println(READ_USER_GAME_COMMAND);
        return readLineWithOutBlank();
    }

    private String readLineWithOutBlank() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}