package calculator;

/**
 * 사용자로부터 연산할 문자열을 입력받는 클래스
 */
public class InputView {
    private static final String INITIAL_PROMPT = "덧셈할 문자열을 입력해 주세요.";

    /**
     * 계산기 시작 안내 문구를 출력하고, 사용자로부터 연산할 문자열을 입력받습니다.
     * @return 사용자가 입력한 문자열
     */
    public String readCalculationInput(){
        displayInitialPrompt();
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    private void displayInitialPrompt() {
        System.out.println(INITIAL_PROMPT);
    }

}
