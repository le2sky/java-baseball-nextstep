package baseballgame.ui;

import baseballgame.application.api.GuessNumberUseCase;

public class ConsoleUIConfiguration {

    public static ConsoleApplication consoleApplication(GuessNumberUseCase guessNumberUseCase) {
        return new ConsoleApplication(consoleBaseballGameController(guessNumberUseCase));
    }

    public static BaseballGameController consoleBaseballGameController(
        GuessNumberUseCase guessNumberUseCase) {
        return new BaseballGameController(guessNumberUseCase);
    }
}
