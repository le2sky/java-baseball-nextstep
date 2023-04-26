package baseballgamev2.domain;

class Ball {

    private final int position;
    private final int number;
    private final int MAX_RANGE = 9;
    private final int MIN_RANGE = 1;

    public Ball(int position, int number) {
        validate(number);
        this.position = position;
        this.number = number;
    }

    private void validate(int number) {
        if (number > MAX_RANGE || number < MIN_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    public BallStatus matchWith(Ball ball) {
        if (isStrike(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.isBall(this.number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isStrike(Ball ball) {
        return this.equals(ball);
    }

    private boolean isBall(int number) {
        return this.number == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ball ball = (Ball) o;

        if (position != ball.position) {
            return false;
        }
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + number;
        return result;
    }
}
