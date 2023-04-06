package calculator;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toCollection;

import java.util.LinkedList;

class ExpressionParser {

  private final OperationFactory factory;

  public ExpressionParser(OperationFactory factory) {
    this.factory = factory;
  }

  public Participants<Integer> parseOperand(String expression) {
    return new Participants<>(stream(replaceOperationIntoBlank(expression))
        .filter(this::isDigit)
        .map(Integer::parseInt)
        .collect(toCollection(LinkedList::new)));
  }

  private String[] replaceOperationIntoBlank(String expression) {
    return expression.replaceAll("[+*/-]", "").split(" ");
  }

  private boolean isDigit(String s) {
    return s.matches("[0-9]+");
  }

  public Participants<Operation> parseOperation(String expression) {
    return new Participants<>(stream(expression.split(""))
        .filter(this::isOperationShape)
        .map(factory::getInstance)
        .collect(toCollection(LinkedList::new)));
  }

  private boolean isOperationShape(String s) {
    return s.matches("[+*/-]");
  }
}
