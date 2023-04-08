package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split_will_contains_one_and_two_string() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void split_will_contains_exactly_one_string() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void substring_will_remove_bracket() {
        String givenString = "(1,2)";
        String actual = givenString.substring(1, givenString.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt은 특정 위치의 문자를 가져온다.")
    void charAtTest() {
        String givenString = "abc";
        assertThat(givenString.charAt(0)).isEqualTo('a');
        assertThat(givenString.charAt(1)).isEqualTo('b');
        assertThat(givenString.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt은 위치 값을 벗어나면 예외를 발생한다.")
    void charAtThrowingTest() {
        String givenString = "abc";
        assertThatThrownBy(() -> {
            givenString.charAt(givenString.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("index out of range: 3");
    }
}
