package baseballgame.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class InputView {

    public static String readUserGuess() {
        InputStream inputStream = System.in;
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        System.out.print("숫자를 입력해 주세요 : ");
        try {
            return bufferedReader.readLine().trim();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
