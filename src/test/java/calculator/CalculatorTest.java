package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

  @ParameterizedTest
  @CsvSource(value = {"1 - 1:0", "3 - 2 - 2:-1", "10 - 3 - 4 - 1:2"}, delimiter = ':')
  void calculate_피연산자_세개_빼기(String source, int expected) {
    assertCalculateWithGivenExpression(source, expected);
  }

  @Test
  void calculate_피연산자_두개_곱하기() {
    assertCalculateWithGivenExpression("2 * 4", 8);
  }

  @Test
  void calculate_피연산자_두개_나누기() {
    assertCalculateWithGivenExpression("9 / 3", 3);
  }

  @Test
  void calculate_더하기_빼기_복합식() {
    assertCalculateWithGivenExpression("9 + 3 - 7", 5);
  }


  private static class Calculator {

    public int calculate(String expression) {
      Queue<String> operation = Arrays.stream(expression.split(" "))
          .filter(s -> s.equals("+") || s.equals("-"))
          .collect(Collectors.toCollection(LinkedList::new));

      List<String> operand = Arrays.stream(expression.split(" "))
          .filter(s -> !s.equals("+") && !s.equals("-"))
          .collect(Collectors.toList());

      int sum = Integer.parseInt(operand.get(0));
      for (int i = 1; i < operand.size(); i++) {
        String op = operation.poll();
        String target = operand.get(i);

        if (op == null) {
          break;
        }
        if (op.equals("+")) {
          sum += Integer.parseInt(target);
        } else if (op.equals("-")) {
          sum -= Integer.parseInt(target);
        }
      }
      return sum;
    }
  }
}
