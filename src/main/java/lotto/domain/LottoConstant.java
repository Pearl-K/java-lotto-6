package lotto.domain;

public enum LottoConstant {

    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    BONUS_NUMBER_COUNT(1);

    private final int value;

    LottoConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
