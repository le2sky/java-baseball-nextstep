package baseballgame.application.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomAnswerGenerator implements AnswerGenerator {

    public Answer generate() {
        List<String> answer = new ArrayList<>();
        while (answer.size() != 3) {
            String rand = Integer.toString((int) (Math.random() * 9 + 1));
            if (!answer.contains(rand)) {
                answer.add(rand);
            }
        }

        return Answer.withAnswer(String.join("", answer));
    }
}
