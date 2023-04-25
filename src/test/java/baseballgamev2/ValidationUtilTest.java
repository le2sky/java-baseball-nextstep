package baseballgamev2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationUtilTest {

    public static final int MAX_SIZE = 3;

    @ParameterizedTest
    @ValueSource(ints = {10, 0, -1})
    void 숫자는_1에서9사이의_수_이다(int source) {
       assertThatThrownBy(() -> {
           new Ball(0, source);
       }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자는_서로_다른_숫자이다() {
        assertThat(validate(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(validate(Arrays.asList(1, 2, 1))).isFalse();
    }

    @Test
    void 숫자는_3자리의_숫자이다() {
        assertThat(validate(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(validate(Arrays.asList(1, 2, 3, 4))).isFalse();
    }

    private boolean validate(List<Integer> list) {
        return validateInRange(list) && validateDuplicate(list);
    }

    private boolean validateInRange(List<Integer> list) {
        return validateSize(list.stream()
            .count());
    }

    private boolean validateDuplicate(List<Integer> list) {
        return validateSize(list.stream()
            .distinct()
            .count());
    }

    private boolean validateSize(long count) {
        return count == MAX_SIZE;
    }
}
