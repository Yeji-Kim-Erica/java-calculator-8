package calculator;

/**
 * 문자열 연산을 담당하는 클래스
 */
public class StringCaculator {
    private static final String DEFAULT_SEPARATOR = ",:";

    String[] separateString(String text) {
        String regex = String.format("[%s]", DEFAULT_SEPARATOR);
        return text.split(regex);
    }
}
