package baseballgamev2;

import static org.assertj.core.api.Assertions.assertThat;

import baseballgamev2.domain.Ball;
import baseballgamev2.domain.BallStatus;
import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    void 아무것도_일치하지_않으면_낫싱() {
        Ball answer = new Ball(1, 1);
        Ball ball = new Ball(1, 3);
        assertThat(ball.matchWith(answer)).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 다른_자리지만_숫자가_일치하면_볼() {
        Ball answer = new Ball(1, 1);
        Ball ball = new Ball(2, 1);
        assertThat(ball.matchWith(answer)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 같은_자리이고_숫자가_일치하면_스트라이크() {
        Ball answer = new Ball(1, 1);
        Ball ball = new Ball(1, 1);
        assertThat(ball.matchWith(answer)).isEqualTo(BallStatus.STRIKE);
    }
}
