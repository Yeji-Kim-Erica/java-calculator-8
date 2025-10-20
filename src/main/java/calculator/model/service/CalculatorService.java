package calculator.model.service;

import calculator.model.domain.Numbers;
import calculator.model.domain.StringParser;

import java.util.Arrays;

/**
 * 문자열 연산을 담당하는 클래스
 */
public class CalculatorService {

    /**
     * 문자열을 분리해 숫자 배열로 변환 후, 총합을 구합니다.
     * @return 문자열 연산 결과값
     */
    public int calculate(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        String[] stringArray = new StringParser().splitByDelimiter(input);
        Numbers numbers = new Numbers(stringArray);
        return numbers.sum();
    }
}
