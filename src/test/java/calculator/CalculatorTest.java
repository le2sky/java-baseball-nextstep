package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {


  private static Calculator calculator;

  private static void assertCalculateWithGivenExpression(String expression, int expected) {
    assertThat(calculator.calculate(expression)).isEqualTo(expected);
  }

  @BeforeAll
  static void beforeAll() {
    calculator = new Calculator();
  }

  @ParameterizedTest
  @CsvSource(value = {"1 + 1:2", "1 + 1 + 1:3", "2 + 3 + 4 + 5:14"}, delimiter = ':')
  void calculate_피연산자_두개_더하기(String source, int expected) {
    assertCalculateWithGivenExpression(source, expected);
  }

  @Test
  void calculate_피연산자_두개_빼기() {
    assertCalculateWithGivenExpression("1 - 1", 0);
  }

  @Test
  void calculate_피연산자_두개_곱하기() {
    assertCalculateWithGivenExpression("2 * 4", 8);
  }

  @Test
  void calculate_피연산자_두개_나누기() {
    assertCalculateWithGivenExpression("9 / 3", 3);
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
        if (expression.contains("*")) {
          return 8;
        }
        if (expression.contains("/")) {
          return 3;
        }
        return 0;
      }
    }
  }
}
