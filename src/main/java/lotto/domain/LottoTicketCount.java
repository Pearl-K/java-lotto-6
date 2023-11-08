package lotto.domain;

import static lotto.domain.LottoConstant.LOTTO_PRICE;
import static lotto.view.ViewErrorMessage.ERROR_INVALID_PRICE;
import static lotto.view.ViewErrorMessage.ERROR_MESSAGE_HEADER;

public class LottoTicketCount {
    public int calculateNumberOfLottoTickets(int purchaseMoney) {
        validateNumberRange(purchaseMoney);
        validateThousandDivision(purchaseMoney);
        return purchaseMoney / LOTTO_PRICE.getValue();
    }

    private static void validateNumberRange(int purchaseMoney) {
        if (purchaseMoney < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER.getMessage() + ERROR_INVALID_PRICE.getMessage());
        }
    }

    private static void validateThousandDivision(int purchaseMoney) {
        if (purchaseMoney % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER.getMessage() + ERROR_INVALID_PRICE.getMessage());
        }
    }
}
