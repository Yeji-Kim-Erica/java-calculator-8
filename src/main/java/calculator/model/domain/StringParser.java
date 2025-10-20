package calculator.model.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 유효한 구분자에 따라 문자열을 분리하는 클래스
 */
public class StringParser {
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String CUSTOM_DELIMITER_EXTRACT_REGEX = "^//(.*)\\\\n(.*)";

    /**
     * 구분자를 기준으로 문자열을 분리합니다.
     * @return 분리된 문자열의 문자열 배열
     */
    public String[] splitByDelimiter(String input) {
        String delimiter = String.format("[%s]", Pattern.quote(DEFAULT_DELIMITERS));
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_EXTRACT_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            validateCustomDelimiter(delimiter);
            delimiter = Pattern.quote(delimiter);
            input = matcher.group(2);
        }
        return input.split(delimiter);
    }

    // 커스텀 구분자 유효성 검사
    private void validateCustomDelimiter(String customDelimiter) {
        boolean exist = customDelimiter != null && !customDelimiter.isEmpty();
        if (!exist) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CUSTOM_DELIMITER.getMessage());
        }
        boolean hasNumber = customDelimiter.matches(".*\\d+.*");
        if (hasNumber) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_CONTAINS_NUMBER.getMessage());
        }
    }
}
