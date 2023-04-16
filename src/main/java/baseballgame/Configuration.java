package baseballgame;

import baseballgame.application.api.GuessNumberUseCase;
import baseballgame.application.domain.Answer;
import baseballgame.application.domain.BaseballGame;
import baseballgame.application.domain.Referee;
import baseballgame.application.service.GuessNumberService;

public class Configuration {

    public static BaseballGame baseballGame() {
        return new BaseballGame(referee());
    }

    private static Referee referee() {
        return new Referee(Answer.withAnswer("123"));
    }

    public static GuessNumberUseCase guessNumberUseCase() {
        return new GuessNumberService(baseballGame());
    }
}
