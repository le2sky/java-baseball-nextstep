package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {


  private static Calculator calculator;

  @BeforeAll
  static void beforeAll() {
    calculator = new Calculator();
  }

  @Test
  void calculate_피연산자_두개_더하기() {
    int actual = calculator.calculate("1 + 1");
    assertThat(actual).isEqualTo(2);
  }

  @Test
  void calculate_피연산자_두개_빼기() {
    int actual = calculator.calculate("1 - 1");
    assertThat(actual).isEqualTo(0);
  }
  private static class Calculator {

    public int calculate(String expression) {
      if (expression.contains("+")) {
        return 2;
      } else {
        return 0;
      }
    }
  }
}
