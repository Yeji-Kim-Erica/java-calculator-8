package calculator;

import java.util.Arrays;

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

    // 문자열을 기본 구분자로 분리
    private String[] separateString(String text) {
        String regex = String.format("[%s]", DEFAULT_SEPARATORS);
        return text.split(regex);
    }

    // 문자열 배열을 숫자 배열로 변환
    private int[] convertToIntArray(String[] stringArray) {
        return Arrays.stream(stringArray)
                .map(String::trim)
                .mapToInt(this::convertToInt)
                .toArray();
    }

    // 문자를 숫자로 변환
    private int convertToInt(String letter) {
        int number;
        try {
            number = Integer.parseInt(letter);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 값이 포함되어 있습니다. : " + letter);
        }

        if (number <= 0) {
            throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다. : " + letter);
        }

        return number;
    }

    // 덧셈 연산
    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
