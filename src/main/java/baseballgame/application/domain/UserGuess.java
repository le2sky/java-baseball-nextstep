package baseballgame.application.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

class UserGuess {

    private final String guess;

    public UserGuess(String guess) {
        checkUserGuess(guess);
        this.guess = guess;
    }

    public String getGuess() {
        return guess;
    }

    private void checkUserGuess(String guess) {
        if (Optional.ofNullable(guess).isEmpty() || guess.isEmpty()) {
            throw new IllegalArgumentException("정답을 입력해주세요.");
        }
        if (!guess.matches("[1-9]+")) {
            throw new IllegalArgumentException("정답에는 숫자만 입력할 수 있습니다.");
        }
        if (guess.length() != 3) {
            throw new IllegalArgumentException("정답은 3자리의 수입니다.");
        }

        Set<String> set = Arrays.stream(guess.split(""))
            .collect(Collectors.toSet());
        if (set.size() != 3) {
            throw new IllegalArgumentException("정답은 서로 다른 숫자입니다.");
        }
    }
}
