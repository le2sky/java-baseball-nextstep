package baseballgamev2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
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
    void 같은_수가_같은_자리에_있다면_스트라이크2() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Ball target = new Ball(2, 2);
        assertThat(balls.play(target)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 같은_수가_같은_자리에_있다면_스트라이크3() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Ball target = new Ball(3, 3);
        assertThat(balls.play(target)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void complex_1스트라이크_1볼() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Balls target = new Balls(Arrays.asList(1, 3, 6));
        assertThat(balls.play(target).getBall()).isEqualTo(1);
        assertThat(balls.play(target).getStrike()).isEqualTo(1);
    }

    @Test
    void complex_2스트라이크() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Balls target = new Balls(Arrays.asList(1, 2, 7));
        assertThat(balls.play(target).getBall()).isEqualTo(0);
        assertThat(balls.play(target).getStrike()).isEqualTo(2);
    }

    @Test
    void complex_2볼() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Balls target = new Balls(Arrays.asList(2, 8, 1));
        assertThat(balls.play(target).getBall()).isEqualTo(2);
        assertThat(balls.play(target).getStrike()).isEqualTo(0);
    }

    @Test
    void complex_3스트라이크면_게임종료() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Balls target = new Balls(Arrays.asList(1, 2, 3));
        assertThat(balls.play(target).isGameOver()).isTrue();
    }
    @Test
    void complex_3스트라이크가_아니면_게임종료_할_수없음() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Balls target = new Balls(Arrays.asList(1, 2, 6));
        assertThat(balls.play(target).isGameOver()).isFalse();
    }
}
