package baseballgamev2.view;

import java.util.Scanner;

public class InputView {

    private static final String READ_USER_BALLS_MESSAGE = "숫자를 입력해 주세요 : ";

    public String readBalls() {
        System.out.print(READ_USER_BALLS_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
