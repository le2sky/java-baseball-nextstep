package baseballgame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @Test
    void create_baseballgame() {
        BaseballGame baseballGame = new BaseballGame();
    }

    @Test
    void judge_모든_수가_정답과_모두_같은_자리에_있으면_스트라이크() {
        BaseballGame baseballGame = new BaseballGame();
        String actual = baseballGame.judge("123");
        assertThat(actual).isEqualTo("3스트라이크");
    }

    private static class BaseballGame {

        public String judge(String s) {
            return "3스트라이크";
        }
    }
}
