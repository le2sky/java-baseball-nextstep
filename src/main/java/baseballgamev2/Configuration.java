package baseballgamev2;

import baseballgamev2.controller.BaseballController;
import baseballgamev2.domain.BallsGenerator;
import baseballgamev2.infrastructure.RandomBallsGenerator;
import baseballgamev2.view.InputView;
import baseballgamev2.view.ResultView;

public class Configuration {

    public static BallsGenerator ballsGenerator() {
        return new RandomBallsGenerator();
    }

    public static BaseballController baseballController() {
        return new BaseballController(new InputView(), new ResultView());
    }
}