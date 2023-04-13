package baseballgame;

import baseballgame.application.domain.Answer;
import baseballgame.application.domain.BaseballGame;
import baseballgame.application.domain.Referee;
import baseballgame.application.service.GuessNumberService;
import baseballgame.ui.GuessNumberController;
import baseballgame.ui.InputView;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        BaseballGame baseballGame = new BaseballGame(new Referee(Answer.withAnswer("123")));
        InputView view = new InputView(new GuessNumberController(new GuessNumberService(baseballGame)));
        view.readUserGuess();
    }
}
