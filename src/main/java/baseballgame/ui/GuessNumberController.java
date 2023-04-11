package baseballgame.ui;

import baseballgame.application.UseCase;

public class GuessNumberController {

    private final UseCase guessNumberUseCase;

    public GuessNumberController(UseCase guessNumberUseCase) {
        this.guessNumberUseCase = guessNumberUseCase;
    }
}
