package baseballgamev2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    void 아무것도_일치하지_않으면_낫싱() {
        Ball answer = new Ball(1, 1);
        Ball ball = new Ball(1, 3);
        Assertions.assertThat(ball.matchWith(answer)).isEqualTo(BallStatus.NOTHING);
    }

    private class Ball {

        public Ball(int i, int i1) {

        }

        public BallStatus matchWith(Ball answer) {
            return BallStatus.NOTHING;
        }
    }
}
