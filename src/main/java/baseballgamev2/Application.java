package baseballgamev2;

import baseballgamev2.controller.BaseballController;

class Application {

    public static void main(String[] args) {
        BaseballController baseballController = Configuration.baseballController();
        baseballController.run();
    }
}