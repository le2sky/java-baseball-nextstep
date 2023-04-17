package baseballgame.application.domain;

public class AnswerGeneratorStub implements AnswerGenerator {

    @Override
    public Answer generate() {
        return Answer.withAnswer("123");
    }
}
