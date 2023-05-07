package baseballgamev2.infrastructure;

import baseballgamev2.domain.Balls;
import baseballgamev2.domain.BallsGenerator;
import java.util.ArrayList;
import java.util.List;

public class RandomBallsGenerator implements BallsGenerator {

    @Override
    public Balls generate() {
        List<Integer> balls = new ArrayList<>();
        while (balls.size() != 3) {
            Integer ball = (int) (Math.random() * 9 + 1);
            if (!balls.contains(ball)) {
                balls.add(ball);
            }
        }

        return new Balls(balls);
    }
}