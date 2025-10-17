package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 기본_구분자로_문자열_분리() {
        // given
        String testString = "1,2:3";
        String[] expected = {"1", "2", "3"};

        // when
        String[] result = stringCalculator.separateString(testString);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
