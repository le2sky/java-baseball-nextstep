package baseballgamev2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidationUtilTest {

    @Test
    void 숫자는_1에서9사이의_수_이다() {
        assertThat(validate(1)).isTrue();
        assertThat(validate(9)).isTrue();
        assertThat(validate(10)).isFalse();
        assertThat(validate(0)).isFalse();
    }

    @Test
    void 숫자는_서로_다른_숫자이다() {
        assertThat(validate(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(validate(Arrays.asList(1, 2, 1))).isFalse();
    }

    private boolean validate(List<Integer> list) {
        return new HashSet<>(list).size() == list.size();
    }

    private boolean validate(int i) {
        return i <= 9 && i >= 1;
    }
}
