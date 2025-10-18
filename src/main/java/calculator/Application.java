package calculator;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        StringCalculator stringCalculator = new StringCalculator();
        OutputView outputView = new OutputView();

        String input = inputView.readCalculationInput();
        int result = stringCalculator.calculate(input);
        outputView.displayCalculationResult(result);

    }
}
