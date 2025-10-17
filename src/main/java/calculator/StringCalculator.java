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

    int[] convertToIntArray(String[] stringArray) {
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = convertToInt(stringArray[i]);
        }
        return intArray;
    }

    private int convertToInt(String letter) {
        int number;
        try {
            number = Integer.parseInt(letter);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 값이 포함되어 있습니다.");
        }

        if (number <= 0) {
            throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다.");
        }

        return number;
    }
}
