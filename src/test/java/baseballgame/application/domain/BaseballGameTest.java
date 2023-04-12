package baseballgame.application.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballGameTest {

    private BaseballGame baseballGame;

    private void assertJudge(String source, String expected) {
        String actual = baseballGame.judge(source);
        assertThat(actual).isEqualTo(expected);
    }

    private void assertJudgeThrowIllegalArgumentExceptionWithMessage(String source,
        String message) {
        assertThatThrownBy(() -> {
            baseballGame.judge(source);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(message);
    }

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGame("123");
    }

    @Test
    void judge_모든_수가_정답과_모두_같은_자리에_있으면_3스트라이크() {
        assertJudge("123", "3스트라이크");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "653", "183"})
    void judge_두가지_수가_정답과_같은_자리에_있으면_2스트라이크(String source) {
        baseballGame.setAnswer("153");
        assertJudge(source, "2스트라이크");
    }

    @ParameterizedTest
    @ValueSource(strings = {"297", "684", "173"})
    void judge_한가지_수가_정답과_같은_자리에_있으면_1스트라이크(String source) {
        baseballGame.setAnswer("283");
        assertJudge(source, "1스트라이크");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "321", "872"})
    void judge_0가지_수가_정답과_같은_자리에_있으면_낫싱(String source) {
        baseballGame.setAnswer("469");
        assertJudge(source, "낫싱");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234", "12", "1"})
    void judge_정답이_3자리_수가_아니면_예외를_발생한다(String source) {
        assertJudgeThrowIllegalArgumentExceptionWithMessage(source, "정답은 3자리의 수입니다.");
    }

    @Test
    void judge_정답이_null이나_빈_문자열인_경우_예외를_발생한다() {
        assertJudgeThrowIllegalArgumentExceptionWithMessage(null, "정답을 입력해주세요.");
        assertJudgeThrowIllegalArgumentExceptionWithMessage("", "정답을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab2", "1ab", "abc", "1a3", "!!!", "@@@", "   ", "1 2", "12 "})
    void judge_정답에_숫자가_아닌_값이_포함되면_예외를_발생한다(String source) {
        assertJudgeThrowIllegalArgumentExceptionWithMessage(source, "정답에는 숫자만 입력할 수 있습니다.");
    }

    @Test
    void judge_정답에_같은_수가_포함되어_있으면_예외를_발생한다() {
        assertJudgeThrowIllegalArgumentExceptionWithMessage("322", "정답은 서로 다른 숫자입니다.");
    }

    @Test
    void judge_세가지_수가_다른_자리에_있으면_3볼이다() {
        baseballGame.setAnswer("321");
        assertJudge("132", "3볼");
    }
}
