package baseballgamev2.domain;

public class BaseballGame {

    private final Balls answer;
    private GameStatus gameStatus;

    public BaseballGame(BallsGenerator ballsGenerator) {
        this.answer = ballsGenerator.generate();
        this.gameStatus = GameStatus.PLAY;
    }

    public boolean isEnd() {
        return gameStatus.isEnd();
    }

    public PlayResult play(Balls userBalls) {
        if (gameStatus.isEnd()) {
            throw new IllegalStateException();
        }

        return getPlayResult(userBalls);
    }

    private PlayResult getPlayResult(Balls userBalls) {
        PlayResult play = answer.play(userBalls);
        if (play.isGameOver()) {
            changeGameStatus();
        }

        return play;
    }

    private void changeGameStatus() {
        this.gameStatus = GameStatus.END;
    }
}

