package baseballgamev2;

import static org.assertj.core.api.Assertions.assertThat;

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

    private class Ball {

        private final int position;
        private final int number;

        public Ball(int position, int number) {
            this.position = position;
            this.number = number;
        }

        public BallStatus matchWith(Ball answer) {
            if(isBall(answer))
                return BallStatus.BALL;
            return BallStatus.NOTHING;
        }

        private boolean isBall(Ball answer) {
            return answer.getNumber() == this.getNumber();
        }

        private int getNumber() {
            return number;
        }
    }
}
