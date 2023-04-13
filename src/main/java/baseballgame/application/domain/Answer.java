package baseballgame.application.domain;

public class Answer {

    private final String answer;

    private Answer(String answer) {
        this.answer = answer;
    }

    public static Answer withAnswer(String answer) {
        return new Answer(answer);
    }

    public boolean contain(String target) {
        return this.answer.contains(target);
    }

    public boolean indexOf(char target, int targetIndex) {
        return this.answer.indexOf(target) == targetIndex;
    }
}
