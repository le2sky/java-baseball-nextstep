package calculator;

class Plus implements Operation {

  @Override
  public int execute(int acc, int target) {
    return acc + target;
  }
}
