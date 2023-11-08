package lotto.domain;

public enum LottoErrorMessage {
    INVALID_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_RANGE("로또 번호는 1에서 45 사이어야 합니다."),
    DUPLICATE_NUMBER("로또 번호에 중복된 숫자가 있습니다."),
    INVALID_BONUS_NUMBER_COUNT("보너스 번호는 1개여야 합니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1에서 45 사이어야 합니다.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
