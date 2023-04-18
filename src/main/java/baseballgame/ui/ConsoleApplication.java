package baseballgame.ui;

public class ConsoleApplication {

    private final ConsoleBaseGameController consoleBaseGameController;

    public ConsoleApplication(ConsoleBaseGameController consoleBaseGameController) {
        this.consoleBaseGameController = consoleBaseGameController;
    }

    public void run() {
        consoleBaseGameController.clear();
        while (!consoleBaseGameController.isGameOver()) {
            consoleBaseGameController.guessNumber();
        }
        if (consoleBaseGameController.restart()) {
            run();
        }
    }
}
