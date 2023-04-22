package baseballgamev2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ValidationUtilTest {

    public static final int MAX_SIZE = 3;
    public static final int MAX_NUMBER_RANGE = 9;
    public static final int MIN_NUMBER_RANGE = 1;

    @Test
    void 숫자는_1에서9사이의_수_이다() {
        assertThat(validateInRangeEach(1)).isTrue();
        assertThat(validateInRangeEach(9)).isTrue();
        assertThat(validateInRangeEach(10)).isFalse();
        assertThat(validateInRangeEach(0)).isFalse();
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
        return validateInRange(list) && validateDuplicate(list);
    }

    private boolean validateInRange(List<Integer> list) {
        return validateSize(list.stream()
            .filter(this::validateInRangeEach)
            .count());
    }

    private boolean validateInRangeEach(int i) {
        return i <= MAX_NUMBER_RANGE && i >= MIN_NUMBER_RANGE;
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
