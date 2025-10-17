package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 문자배열을_숫자배열로_변환() {
        // given
        String[] testArray = {"1", "2", "3"};
        int[] expected = {1, 2, 3};

        // when
        int[] result = stringCalculator.convertToIntArray(testArray);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 숫자가_아닌_문자_포함시_예외발생() {
        // given
        String[] testArray = {"1", "r", "3"};

        // when & then
        assertThatThrownBy(() -> stringCalculator.convertToIntArray(testArray))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈문자열_포함시_예외발생() {
        // given
        String[] testArray = {"", "2", "3"};

        // when & then
        assertThatThrownBy(() -> stringCalculator.convertToIntArray(testArray))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void zero_포함시_예외발생() {
        // given
        String[] testArray = {"0", "2", "3"};

        // when & then
        assertThatThrownBy(() -> stringCalculator.convertToIntArray(testArray))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_포함시_예외발생() {
        // given
        String[] testArray = {"1", "-1651", "3"};

        // when & then
        assertThatThrownBy(() -> stringCalculator.convertToIntArray(testArray))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
