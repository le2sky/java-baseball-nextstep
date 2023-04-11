package baseballgame;

import baseballgame.application.domain.BaseballGame;
import baseballgame.application.service.GuessNumberGuessNumberUseCase;
import baseballgame.ui.GuessNumberController;
import baseballgame.ui.InputView;

public class main {

    public static void main(String[] args) {
        InputView view = new InputView(new GuessNumberController(new GuessNumberGuessNumberUseCase()));
        BaseballGame baseballGame = new BaseballGame("123");
    }
}
