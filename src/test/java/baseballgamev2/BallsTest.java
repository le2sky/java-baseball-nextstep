package baseballgamev2;

import static org.assertj.core.api.Assertions.assertThat;

import baseballgamev2.BallTest.Ball;
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

    public static class Balls {

        public <T> Balls(List<T> list) {
        }

        public BallStatus play(Ball ball) {
            return BallStatus.NOTHING;
        }
    }
}
