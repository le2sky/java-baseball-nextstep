package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
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
  void calculate_피연산자_세개_더하기() {
    int actual = calculator.calculate("1 + 1 + 1");
    assertThat(actual).isEqualTo(3);
  }
  @Test
  void calculate_피연산자_두개_빼기() {
    int actual = calculator.calculate("1 - 1");
    assertThat(actual).isEqualTo(0);
  }


  private static class Calculator {

    public int calculate(String expression) {
      if (expression.contains("+")) {
        return Arrays.stream(expression.split(" "))
            .filter(s -> !s.equals("+"))
            .collect(Collectors.toList()).stream()
            .mapToInt(Integer::parseInt)
            .sum();

      } else {
        return 0;
      }
    }
  }
}
