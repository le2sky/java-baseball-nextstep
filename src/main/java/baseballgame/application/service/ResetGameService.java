package baseballgame.application.service;

import baseballgame.application.api.ResetGameUseCase;
import baseballgame.application.domain.BaseballGame;

public class ResetGameService implements ResetGameUseCase {

    private final BaseballGame baseballGame;

    public ResetGameService(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    @Override
    public void execute() {
        baseballGame.reset();
    }
}
