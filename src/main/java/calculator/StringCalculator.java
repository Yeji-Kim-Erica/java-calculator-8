package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열 연산을 담당하는 클래스
 */
public class StringCalculator {
    private static final String DEFAULT_SEPARATORS = ",:";

    /**
     * 문자열을 분리해 숫자 배열로 변환 후, 총합을 구합니다.
     * @return 문자열 연산 결과값
     */
    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        return sum(convertToIntArray(separateString(input)));
    }

    // 문자열을 구분자로 분리
    private String[] separateString(String text) {
        Pattern pattern = Pattern.compile("^//(.*)\\\\n(.*)");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            validateCustomSeparator(customSeparator);
            return splitByCustomSeparators(matcher.group(2), customSeparator);
        }

        return splitByDefaultSeparators(text);
    }

    // 문자열을 기본 구분자로 분리
    private String[] splitByDefaultSeparators(String text) {
        String regex = String.format("[%s]", DEFAULT_SEPARATORS);
        return text.split(regex);
    }

    // 문자열을 커스텀 구분자로 분리
    private String[] splitByCustomSeparators(String text, String customSeparator) {
        String regex = String.format("[%s]", customSeparator);
        return text.split(regex);
    }
    
    // 커스텀 구분자 유효성 검사
    private void validateCustomSeparator(String customSeparator) {
        boolean exist = customSeparator != null && !customSeparator.isEmpty();
        if (!exist) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CUSTOM_SEPARATOR.getMessage());
        }
        boolean hasNumber = customSeparator.matches(".*\\d+.*");
        if (hasNumber) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_SEPARATOR_CONTAINS_NUMBER.getMessage());
        }
    }

    // 문자열 배열을 숫자 배열로 변환
    private int[] convertToIntArray(String[] stringArray) {
        return Arrays.stream(stringArray)
                .map(String::trim)
                .mapToInt(this::convertToInt)
                .map(this::validatePositive)
                .toArray();
    }

    // 문자를 숫자로 변환
    private int convertToInt(String letter) {
        if (letter == null || letter.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_STRING_TO_NUMERIC.getMessage());
        }

        int number;
        try {
            number = Integer.parseInt(letter);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CONVERTIBLE_TO_NUMERIC.getMessageWithCause(letter));
        }

        return number;
    }

    // 양수 유효성 검사
    private int validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER.getMessageWithCause(number));
        }
        return number;
    }

    // 덧셈 연산
    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
