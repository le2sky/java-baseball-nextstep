package baseballgame.ui;

public class ConsoleApplication {

    private final BaseballGameController baseballGameController;

    public ConsoleApplication(BaseballGameController baseballGameController) {
        this.baseballGameController = baseballGameController;
    }

    public void run() {
        baseballGameController.clear();
        while (!baseballGameController.isGameOver()) {
            baseballGameController.guessNumber();
        }
        if (baseballGameController.restart()) {
            run();
        }
    }
}
