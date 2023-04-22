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

    @Test
    void 같은_자리이고_숫자가_일치하면_스트라이크() {
        Ball answer = new Ball(1, 1);
        Ball ball = new Ball(1, 1);
        assertThat(ball.matchWith(answer)).isEqualTo(BallStatus.STRIKE);
    }

    private class Ball {

        private final int position;
        private final int number;

        public Ball(int position, int number) {
            this.position = position;
            this.number = number;
        }

        public BallStatus matchWith(Ball answer) {
            if (isStrike(answer)) {
                return BallStatus.STRIKE;
            }
            if (answer.isBall(this.number)) {
                return BallStatus.BALL;
            }
            return BallStatus.NOTHING;
        }

        private boolean isStrike(Ball answer) {
            return this.equals(answer);
        }

        private boolean isBall(int number) {
            return this.number == number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Ball ball = (Ball) o;

            if (position != ball.position) {
                return false;
            }
            return number == ball.number;
        }

        @Override
        public int hashCode() {
            int result = position;
            result = 31 * result + number;
            return result;
        }
    }
}
