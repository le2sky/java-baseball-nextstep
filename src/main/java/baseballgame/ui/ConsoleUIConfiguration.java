package baseballgame.ui;

import baseballgame.application.api.GuessNumberUseCase;
import baseballgame.application.api.ResetGameUseCase;

public class ConsoleUIConfiguration {

    public static ConsoleApplication consoleApplication(GuessNumberUseCase guessNumberUseCase,
        ResetGameUseCase resetGameUseCase) {
        return new ConsoleApplication(
            consoleBaseballGameController(guessNumberUseCase, resetGameUseCase));
    }

    public static BaseballGameController consoleBaseballGameController(
        GuessNumberUseCase guessNumberUseCase, ResetGameUseCase resetGameUseCase) {
        return new BaseballGameController(guessNumberUseCase, resetGameUseCase);
    }
}
