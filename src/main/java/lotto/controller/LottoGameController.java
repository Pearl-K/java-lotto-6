package lotto.controller;

import java.util.List;
import lotto.domain.LottoRandomNumberGenerator;
import lotto.domain.LottoTicketCount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public void run() {
        int purchaseMoney = InputView.inputLottoPurchaseMoney();

        LottoTicketCount ticketCount = new LottoTicketCount();
        int numberOfLottoTickets = ticketCount.calculateNumberOfLottoTickets(purchaseMoney);

        LottoRandomNumberGenerator randomLottos = new LottoRandomNumberGenerator();
        List<List<Integer>> randomLottoNumbers = randomLottos.generateRandomNumbers(numberOfLottoTickets);
        OutputView.printPurchaseResult(numberOfLottoTickets);
        OutputView.printLottoNumbers(randomLottoNumbers);

        List<Integer> lottoWinningNumbers = InputView.inputLottoWinningNumber();


    }
}