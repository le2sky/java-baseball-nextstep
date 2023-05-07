package baseballgamev2.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private static final int MAX_SIZE = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> list) {
        validate(list);
        this.balls = mapToBalls(list);
    }

    private List<Ball> mapToBalls(List<Integer> list) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            balls.add(new Ball(i + 1, list.get(i)));
        }

        return balls;
    }

    private void validate(List<Integer> list) {
        if (getNotDuplicatedNumberSize(list) != MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private long getNotDuplicatedNumberSize(List<Integer> list) {
        return list.stream()
            .distinct()
            .count();
    }

    public PlayResult play(Balls target) {
        PlayResult playResult = PlayResult.without();
        target.getBalls()
            .forEach(ball -> increase(playResult, play(ball)));

        return playResult;
    }

    public BallStatus play(Ball ball) {
        return balls.stream()
            .map(ball::matchWith)
            .filter(this::isMatchAtLeastOne)
            .findFirst()
            .orElse(BallStatus.NOTHING);
    }

    private boolean isMatchAtLeastOne(BallStatus ballStatus) {
        return !ballStatus.isNothing();
    }

    private void increase(PlayResult playResult, BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            playResult.increaseStrike();
        }
        if (ballStatus.isBall()) {
            playResult.increaseBall();
        }
    }

    private List<Ball> getBalls() {
        return this.balls;
    }
}
