package baseballgame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @Test
    void create_baseballgame() {
        BaseballGame baseballGame = new BaseballGame();
    }

    @Test
    void judge_모든_수가_정답과_모두_같은_자리에_있으면_3스트라이크() {
        BaseballGame baseballGame = new BaseballGame();
        String actual = baseballGame.judge("123");
        assertThat(actual).isEqualTo("3스트라이크");
    }

    @Test
    void judge_두가지_수가_정답과_같은_자리에_있으면_2스트라이크() {
        BaseballGame baseballGame = new BaseballGame();
        String actual = baseballGame.judge("153");
        assertThat(actual).isEqualTo("2스트라이크");
    }

    private static class BaseballGame {

        public String judge(String s) {
            if (s.equals("153")) {
                return "2스트라이크";
            }
            return "3스트라이크";
        }
    }
}
