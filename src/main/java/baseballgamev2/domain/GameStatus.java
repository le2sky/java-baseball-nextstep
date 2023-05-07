package baseballgamev2.domain;

enum GameStatus {

    PLAY, END;

    boolean isEnd() {
        return this == END;
    }
}