package baseballgamev2.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseballgamev2.domain.Ball;
import baseballgamev2.domain.Balls;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallAndBallsValidationTest {

    @ParameterizedTest
    @ValueSource(ints = {10, 0, -1})
    void 숫자는_1에서9사이의_수_이다(int source) {
        assertThatThrownBy(() -> {
            new Ball(0, source);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자는_서로_다른_숫자이다() {
        assertThatThrownBy(() -> {
            new Balls(Arrays.asList(1, 2, 1));
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new Balls(Arrays.asList(1, 9, 9));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자는_3자리의_숫자이다() {
        assertThatThrownBy(() -> {
            new Balls(Arrays.asList(1, 9, 6, 3));
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new Balls(Arrays.asList(1, 9));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
