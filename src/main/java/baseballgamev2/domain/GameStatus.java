package baseballgamev2.domain;

public enum GameStatus {
    PLAY, END;

    public boolean isEnd() {
        return this == END;
    }
}
