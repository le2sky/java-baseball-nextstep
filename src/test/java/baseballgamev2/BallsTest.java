package baseballgamev2;

import static org.assertj.core.api.Assertions.assertThat;

import baseballgamev2.BallTest.Ball;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    void 아무것도_일치하지_않으면_낫싱() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Ball target = new Ball(3, 7);
        assertThat(balls.play(target)).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 같은_수가_다른_자리에_있다면_볼() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Ball target = new Ball(3, 1);
        assertThat(balls.play(target)).isEqualTo(BallStatus.BALL);
    }

    public static class Balls {

        private final List<Ball> balls;

        public Balls(List<Integer> list) {
            this.balls = mapToBalls(list);

        }

        private List<Ball> mapToBalls(List<Integer> list) {
            List<Ball> balls = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                balls.add(new Ball(i + 1, list.get(i)));
            }
            return balls;
        }

        public BallStatus play(Ball ball) {
            return balls.stream()
                .map(ball::matchWith)
                .findFirst()
                .orElse(BallStatus.NOTHING);
        }
    }
}
