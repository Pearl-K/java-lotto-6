package lotto.domain;

import static lotto.domain.LottoConstant.LOTTO_PRICE;

public class LottoTicketCount {
    public int calculateNumberOfLottoTickets(int purchaseMoney) {
        return purchaseMoney / LOTTO_PRICE.getValue();
    }
}
