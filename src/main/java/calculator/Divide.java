package calculator;

class Divide implements Operation {

  @Override
  public int execute(int acc, int target) {
    return acc / target;
  }
}
