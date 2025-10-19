package calculator;

public enum ErrorMessage {
    NOT_CONVERTIBLE_TO_NUMERIC("숫자로 변환할 수 없는 값이 포함되어 있습니다."),
    EMPTY_STRING_TO_NUMERIC("숫자 값은 비어 있을 수 없습니다."),
    NOT_POSITIVE_NUMBER("양수가 아닌 값이 포함되어 있습니다."),
    EMPTY_CUSTOM_SEPARATOR("커스텀 구분자는 비어 있을 수 없습니다."),
    CUSTOM_SEPARATOR_CONTAINS_NUMBER("커스텀 구분자에 숫자를 포함할 수 없습니다.");

    private final String message;
    private static final String ERROR_PREFIX = "[오류 발생] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }

    public String getMessageWithCause(Object cause) {
        return ERROR_PREFIX + message + " : '" + cause.toString() + "'";
    }
}
