package baseballgame;

import baseballgame.ui.ConsoleApplication;
import baseballgame.ui.ConsoleUIConfiguration;

public class Main {

    public static void main(String[] args) {
        ConsoleApplication consoleApplication = ConsoleUIConfiguration.consoleApplication(
            Configuration.guessNumberUseCase());
        consoleApplication.run();
    }
}
