package baseballgame;

import static org.assertj.core.api.Assertions.assertThat;

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
    @ValueSource(strings = {"123", "653", "173"})
    void judge_한가지_수가_정답과_같은_자리에_있으면_1스트라이크(String source) {
        baseballGame.setAnswer("283");
        assertJudge(source, "1스트라이크");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "653", "173"})
    void judge_0가지_수가_정답과_같은_자리에_있으면_빈문자열(String source) {
        baseballGame.setAnswer("469");
        assertJudge(source, "");
    }


    private static class BaseballGame {

        private String answer;

        public BaseballGame(String answer) {
            this.answer = answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String judge(String target) {
            int strike = getStrike(target);
            if (strike == 0) {
                return "";
            }
            return strike + "스트라이크";
        }

        private int getStrike(String target) {
            int strike = 0;
            for (int i = 0; i < target.length(); i++) {
                if (isStrike(target.charAt(i), i)) {
                    strike++;
                }
            }
            return strike;
        }

        private boolean isStrike(char target, int targetIndex) {
            return answer.indexOf(target) == targetIndex;
        }
    }
}
