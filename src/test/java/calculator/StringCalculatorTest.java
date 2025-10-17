package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    void 기본_구분자로_문자열_분리() {
        // given
        StringCaculator stringCaculator = new StringCaculator();
        String testString = "1,2:3";
        String[] expected = {"1", "2", "3"};

        // when
        String[] result = stringCaculator.separateString(testString);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
