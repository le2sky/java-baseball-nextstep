package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {


  @Test
  void create_calculator() {
    Calculator calculator = new Calculator();
  }

  @Test
  void plus_test() {
    Calculator calculator = new Calculator();
    int actual = calculator.calculte("1 + 1");
    assertThat(actual).isEqualTo(2);
  }


  private class Calculator {

    public int calculte(String s) {
      return 2;
    }
  }
}
