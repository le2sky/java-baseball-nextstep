package baseballgame.ui;

public class ConsoleApplication {

    private final BaseballGameController baseballGameController;

    public ConsoleApplication(BaseballGameController baseballGameController) {
        this.baseballGameController = baseballGameController;
    }

    public void run() {
        while (!baseballGameController.isGameOver()) {
            baseballGameController.guessNumber();
        }
    }
}
