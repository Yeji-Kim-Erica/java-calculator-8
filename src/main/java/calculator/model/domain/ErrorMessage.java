package calculator.model.domain;

/**
 * domain 내에서 발생할 수 있는 오류 메시지를 정의한 클래스
 */
public enum ErrorMessage {
    NOT_CONVERTIBLE_TO_NUMERIC("숫자로 변환할 수 없는 값이 포함되어 있습니다."),
    EMPTY_STRING_TO_NUMERIC("숫자 값은 비어 있을 수 없습니다."),
    NOT_POSITIVE_NUMBER("양수가 아닌 값이 포함되어 있습니다."),
    EMPTY_CUSTOM_DELIMITER("커스텀 구분자는 비어 있을 수 없습니다."),
    CUSTOM_DELIMITER_CONTAINS_NUMBER("커스텀 구분자에 숫자를 포함할 수 없습니다.");

    private final String message;
    private static final String ERROR_PREFIX = "[오류 발생] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    /**
     * 상황에 맞는 오류 메시지를 반환합니다.
     * @return 오류 메시지 (형식: [오류 발생] 해당 오류 내용)
     */
    public String getMessage() {
        return ERROR_PREFIX + message;
    }

    /**
     * 상황에 맞는 오류 메시지를 오류의 원인이 된 값과 함께 반환합니다.
     * @return 오류 메시지 (형식: [오류 발생] 해당 오류 내용 : '오류 원인값')
     */
    public String getMessageWithCause(Object cause) {
        String causeStr = cause == null ? "" : cause.toString();
        return ERROR_PREFIX + message + " : '" + causeStr + "'";
    }
}
