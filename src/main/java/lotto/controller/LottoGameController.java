package lotto.controller;

import java.util.List;
import lotto.domain.LottoRandomNumberGenerator;
import lotto.domain.LottoTicketCount;
import lotto.view.InputView;

public class LottoGameController {

    public void run() {
        int purchaseMoney = InputView.inputLottoPurchaseMoney();

        LottoTicketCount ticketCount = new LottoTicketCount();
        int numberOfLottoTickets = ticketCount.calculateNumberOfLottoTickets(purchaseMoney);

        LottoRandomNumberGenerator randomLottos = new LottoRandomNumberGenerator();
        List<List<Integer>> randomLottoNumbers = randomLottos.generateRandomNumbers(numberOfLottoTickets);

        InputView.inputLottoWinningNumber();

        int bonusNumber = InputView.inputBonusNumber();

    }

    public static void main(String[] args) {
        LottoGameController controller = new LottoGameController();
        controller.run();
    }
}