package baseballgame.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputView {

    private final GuessNumberController guessNumberController;

    public InputView(GuessNumberController baseballGameController) {
        this.guessNumberController = baseballGameController;
    }

    public void readUserGuess() throws IOException {
        InputStream inputStream = System.in;
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        System.out.print("숫자를 입력해 주세요 : ");
        String userGuess = bufferedReader.readLine();

        guessNumberController.guessNumber(userGuess);
    }
}
