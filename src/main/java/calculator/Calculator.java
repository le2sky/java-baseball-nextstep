package calculator;

import static java.util.Optional.ofNullable;

class Calculator {

  private final ExpressionParser parser;

  public Calculator(ExpressionParser parser) {
    this.parser = parser;
  }

  public int calculate(String expression) {
    checkNullExpression(expression);
    checkValidExpression(expression);
    return calculateParticipants(parser.parseOperation(expression),
        parser.parseOperand(expression));
  }

  private int calculateParticipants(Participants<Operation> operations,
      Participants<Integer> operands) {
    int sum = operands.nextParticipant();
    while (!operations.isEmpty()) {
      Operation operation = operations.nextParticipant();
      sum = operation.execute(sum, operands.nextParticipant());
    }

    return sum;
  }

  private void checkValidExpression(String expression) {
    if (!expression.matches("[0-9\\s+*/-]+")) {
      throw new IllegalArgumentException();
    }
  }

  private void checkNullExpression(String expression) {
    if (ofNullable(expression).isEmpty()) {
      throw new IllegalArgumentException();
    }
  }
}
