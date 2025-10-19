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

    // 정상 케이스 -----

    @Test
    void calculate_정상_기본구분자() {
        assertThat(stringCalculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    void calculate_정상_공백포함() {
        assertThat(stringCalculator.calculate("1,2 : 3")).isEqualTo(6);
    }

    @Test
    void calculate_정상_커스텀구분자() {
        assertThat(stringCalculator.calculate("//;\\n1;2;3")).isEqualTo(6);
    }

    // 예외 케이스 -----

    @Test
    void calculate_숫자가아닌문자_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate("1,r,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_CONVERTIBLE_TO_NUMERIC.getMessage());
    }

    @Test
    void calculate_빈문자열_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate("1:,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_STRING_TO_NUMERIC.getMessage());
    }

    @Test
    void calculate_0포함_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate("0,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE_NUMBER.getMessage());
    }

    @Test
    void calculate_음수포함_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate("1:-1651,3"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.NOT_POSITIVE_NUMBER.getMessage());
    }

    @Test
    void calculate_커스텀구분자_뒤_빈문자열_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate("//;\\n"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_STRING_TO_NUMERIC.getMessage());
    }

    @Test
    void calculate_커스텀구분자_빈문자열_지정_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate("//\\n123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_CUSTOM_SEPARATOR.getMessage());
    }

    @Test
    void calculate_커스텀구분자_숫자포함_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate("//.5:\\n1.5:2.5:3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CUSTOM_SEPARATOR_CONTAINS_NUMBER.getMessage());
    }
}
