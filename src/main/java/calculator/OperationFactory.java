package calculator;

class OperationFactory {

    public Operation getInstance(String key) {
        switch (key) {
            case "+":
                return new Plus();
            case "-":
                return new Subtract();
            case "*":
                return new Multiply();
            case "/":
                return new Divide();
            default:
                throw new IllegalArgumentException();
        }
    }
}
