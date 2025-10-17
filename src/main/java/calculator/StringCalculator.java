package calculator;

import java.util.Arrays;

/**
 * 문자열 연산을 담당하는 클래스
 */
public class StringCalculator {
    private static final String DEFAULT_SEPARATORS = ",:";

    String[] separateString(String text) {
        String regex = String.format("[%s]", DEFAULT_SEPARATORS);
        return text.split(regex);
    }
}
