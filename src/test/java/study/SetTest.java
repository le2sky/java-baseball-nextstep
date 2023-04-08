package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>(List.of(1, 1, 2, 3));
    }

    @Test
    void size_set의_크기를_확인한다() {
        int actual = numbers.size();
        assertThat(actual).isEqualTo(3);
    }

    @ParameterizedTest(name = "[contains 테스트 {index}] : {0}이 존재하는가?")
    @ValueSource(ints = {1, 2, 3})
    void contains_값이_존재하는지_확인한다(int source) {
        boolean actual = numbers.contains(source);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "[contains csv 테스트 {index}] : {0}이 존재하는가? => {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containse_csv를_이용해서_값이_존재하는지_확인한다(int source, boolean expteced) {
        assertThat(numbers.contains(source)).isEqualTo(expteced);
    }
}
