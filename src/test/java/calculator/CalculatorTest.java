package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {


  private static Calculator calculator;

  private static void assertCalculateWithGivenExpression(String expression, int expected) {
    assertThat(calculator.calculate(expression)).isEqualTo(expected);
  }

  @BeforeAll
  static void beforeAll() {
    calculator = new Calculator();
  }

  @Test
  void calculate_피연산자_두개_더하기() {
    assertCalculateWithGivenExpression("1 + 1", 2);
  }

  @Test
  void calculate_피연산자_세개_더하기() {
    assertCalculateWithGivenExpression("1 + 1 + 1", 3);
  }

  @Test
  void calculate_피연산자_두개_빼기() {
    assertCalculateWithGivenExpression("1 - 1", 0);
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
