package calculator.controller;

import calculator.model.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * 문자열 덧셈 계산기의 전체 흐름을 담당하는 클래스
 */
public class CalculatorController {

    /**
     * 사용자에게 문자열을 입력받아 연산 후, 덧셈 결과를 출력합니다.
     */
    public void run() {
        InputView inputView = new InputView();
        CalculatorService calculatorService = new CalculatorService();
        OutputView outputView = new OutputView();

        String input = inputView.readCalculationInput();
        int result = calculatorService.calculate(input);
        outputView.displayCalculationResult(result);
    }
}
