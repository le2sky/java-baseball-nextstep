package baseballgame.ui;

import baseballgame.application.api.GuessNumberUseCase;

public class GuessNumberController {

    private final GuessNumberUseCase guessNumberUseCase;

    public GuessNumberController(GuessNumberUseCase guessNumberUseCase) {
        this.guessNumberUseCase = guessNumberUseCase;
    }

    public void guessNumber(String userGuess) {
        ResultView.renderResult(guessNumberUseCase.execute(userGuess));
    }
}
