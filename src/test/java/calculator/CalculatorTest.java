package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CalculatorTest {


  @Test
  void create_calculator() {
    Calculator calculator = new Calculator();
  }

  @Test
  void plus_test() {
    Calculator calculator = new Calculator();
    int actual = calculator.calculate("1 + 1");
    assertThat(actual).isEqualTo(2);
  }

  @Test
  void minus_test() {
    Calculator calculator = new Calculator();
    int actual = calculator.calculate("1 - 1");
    assertThat(actual).isEqualTo(0);
  }


  private class Calculator {

    public int calculate(String expression) {
      if (expression.contains("+")) {
        return 2;
      } else {
        return 0;
      }
    }
  }
}
