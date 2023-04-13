package baseballgame.application.service;

import baseballgame.application.api.GuessNumberResponse;
import baseballgame.application.api.GuessNumberUseCase;
import baseballgame.application.domain.BaseballGame;
import baseballgame.application.domain.RoundResult;
import baseballgame.application.domain.UserGuess;

public class GuessNumberService implements GuessNumberUseCase {


    private final BaseballGame baseballGame;

    public GuessNumberService(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    @Override
    public GuessNumberResponse execute(String userGuess) {
        RoundResult answer = baseballGame.judge(new UserGuess(userGuess));
        return new GuessNumberResponse(answer.getBall(), answer.getStrike());
    }
}
