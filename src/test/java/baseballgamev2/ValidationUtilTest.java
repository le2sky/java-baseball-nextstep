package baseballgamev2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidationUtilTest {

    @Test
    void 숫자는_1에서9사이의_수_이다() {
        assertThat(validateEach(1)).isTrue();
        assertThat(validateEach(9)).isTrue();
        assertThat(validateEach(10)).isFalse();
        assertThat(validateEach(0)).isFalse();
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

    @Test
    void 숫자는_서로_다른_세자리_의_1부터_9_사이의_숫자이다() {
        assertThat(validate(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(validate(Arrays.asList(1, 0, 3))).isFalse();
        assertThat(validate(Arrays.asList(1, 3))).isFalse();
        assertThat(validate(Arrays.asList(9, 0))).isFalse();
    }

    private boolean validate(List<Integer> list) {
        return validateSize(countInRange(list)) && validateDuplicate(list);
    }

    private boolean validateSize(long count) {
        return count == 3;
    }

    private long countInRange(List<Integer> list) {
        return list.stream()
            .filter(this::validateEach)
            .count();
    }

    private boolean validateEach(int i) {
        return i <= 9 && i >= 1;
    }

    private boolean validateDuplicate(List<Integer> list) {
        return new HashSet<>(list).size() == list.size();
    }
}
