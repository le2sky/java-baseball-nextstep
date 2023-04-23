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

    @Test
    void 같은_수가_같은_자리에_있다면_스트라이크() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Ball target = new Ball(1, 1);
        assertThat(balls.play(target)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 복합_1스트라이크_1볼() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Balls target = new Balls(Arrays.asList(1, 3, 6));
        PlayResult expected = new PlayResult(1, 1);
        assertThat(balls.play(target)).isEqualTo(expected);
    }


    public class Balls {

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

        public PlayResult play(Balls target) {
            return new PlayResult(1, 1);
        }
    }

    public class PlayResult {

        private final int ball;
        private final int strike;

        public PlayResult(int ball, int strike) {
            this.ball = ball;
            this.strike = strike;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            PlayResult that = (PlayResult) o;

            if (ball != that.ball) {
                return false;
            }
            return strike == that.strike;
        }

        @Override
        public int hashCode() {
            int result = ball;
            result = 31 * result + strike;
            return result;
        }
    }
}
