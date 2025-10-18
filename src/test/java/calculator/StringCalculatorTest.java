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

    // 예외 케이스 -----

    @Test
    void calculate_숫자가아닌문자_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate("1,r,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculate_빈문자열_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate(":2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculate_0포함_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate("0,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculate_음수포함_예외발생() {
        assertThatThrownBy(() -> stringCalculator.calculate("1:-1651,3"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
