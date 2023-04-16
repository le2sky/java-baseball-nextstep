package baseballgame.ui;

import baseballgame.application.api.GuessNumberResponse;
import baseballgame.application.api.GuessNumberUseCase;

class BaseballGameController {

    private final GuessNumberUseCase guessNumberUseCase;
    private boolean isGameOver;

    public BaseballGameController(GuessNumberUseCase guessNumberUseCase) {
        this.guessNumberUseCase = guessNumberUseCase;
        this.isGameOver = false;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void guessNumber() {
        GuessNumberResponse response = guessNumberUseCase.execute(InputView.readUserGuess());
        ResultView.renderResult(response);
        checkGameOver(response);
    }

    private void checkGameOver(GuessNumberResponse response) {
        if (response.getStrike() == 3) {
            isGameOver = true;
        }
    }
}
