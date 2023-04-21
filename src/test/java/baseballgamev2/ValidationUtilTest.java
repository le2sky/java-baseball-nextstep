package baseballgamev2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidationUtilTest {

  @Test
  void 숫자는_1에서9사이의_수_이다() {
    assertThat(validate(1)).isTrue();
    assertThat(validate(9)).isTrue();
    assertThat(validate(10)).isFalse();
    assertThat(validate(0)).isFalse();
  }

  private boolean validate(int i) {
    return i <= 9 && i >= 1;
  }
}
