package baseballgame;

import baseballgame.application.api.GuessNumberUseCase;
import baseballgame.application.api.ResetGameUseCase;
import baseballgame.application.domain.Answer;
import baseballgame.application.domain.AnswerGenerator;
import baseballgame.application.domain.BaseballGame;
import baseballgame.application.domain.RandomAnswerGenerator;
import baseballgame.application.domain.Referee;
import baseballgame.application.service.GuessNumberService;
import baseballgame.application.service.ResetGameService;

public class Configuration {

    private static final BaseballGame baseballGame = new BaseballGame(referee(), answerGenerator());

    private static Referee referee() {
        return new Referee(Answer.withAnswer("123"));
    }

    private static AnswerGenerator answerGenerator() {
        return new RandomAnswerGenerator();
    }

    public static GuessNumberUseCase guessNumberUseCase() {
        return new GuessNumberService(baseballGame);
    }

    public static ResetGameUseCase resetGameUseCase() {
        return new ResetGameService(baseballGame);
    }
}
