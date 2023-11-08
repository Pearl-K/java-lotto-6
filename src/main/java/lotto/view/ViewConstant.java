package lotto.view;

public enum ViewConstant {
    INPUT_LOTTO_PURCHASE_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_LOTTO_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    SEPARATOR(","),
    ERROR_MESSAGE_HEADER("[ERROR] "),
    ERROR_INPUT_IS_NOT_NUMBER("숫자만 입력 가능합니다."),
    ERROR_INVALID_INPUT("번호를 형식에 맞게 입력해 주세요."),

    NUMBER_OF_LOTTO_PURCHASED_MESSAGE("%d개를 구매했습니다."),
    STATISTICS_FOREWORD_MESSAGE("당첨통계"),
    DOUBLED_DASH("--"),
    STATISTICS_WITH_BONUS_RESULT_MESSAGE("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    STATISTICS_RESULT_MESSAGE("%d개 일치 (%,d원) - %d개"),
    RESULT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");


    private final String message;

    ViewConstant(String string) {
        this.message = string;
    }

    public String getMessage() {
        return message;
    }

}