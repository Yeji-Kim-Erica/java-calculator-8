package calculator.model.domain;

import java.util.Arrays;

/**
 * 숫자 도메인 클래스
 */
public class Numbers {
    private final int[] numberArray;

    public Numbers(String[] stringArray) {
        this.numberArray = convertToIntArray(stringArray);
    }

    /**
     * 숫자 배열에 있는 숫자들의 총합을 구한다.
     * @return 덧셈 결과값
     */
    public int sum() {
        return Arrays.stream(numberArray).sum();
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
}
