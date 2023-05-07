package baseballgamev2.controller;

import baseballgamev2.Configuration;
import baseballgamev2.domain.BaseballGame;
import baseballgamev2.domain.PlayResult;
import baseballgamev2.view.InputView;
import baseballgamev2.view.ResultView;

public class BaseballController {

    private final InputView inputView;
    private final ResultView resultView;

    public BaseballController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        play(new BaseballGame(Configuration.ballsGenerator()));
    }

    private void play(BaseballGame game) {
        playGameUntilEnd(game);
        replay();
    }

    private void playGameUntilEnd(BaseballGame game) {
        while (!game.isEnd()) {
            PlayResult result = game.play(InputMapper.mapToBalls(inputView.readBalls()));
            resultView.writeResult(result);
        }

        resultView.writeGameEndMessage();
    }

    private void replay() {
        GameCommand userCommand = InputMapper.mapToCommand(inputView.readReplayCommand());
        if (userCommand.isReplay()) {
            run();
        }
    }
}