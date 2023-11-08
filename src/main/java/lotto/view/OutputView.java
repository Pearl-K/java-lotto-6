package lotto.view;

import static lotto.view.ViewErrorMessage.NUMBER_OF_LOTTO_PURCHASED_MESSAGE;

import java.util.List;

public class OutputView {
    public static void printPurchaseResult(int numberOfLottoPurchased) {
        System.out.println();
        System.out.println(String.format(NUMBER_OF_LOTTO_PURCHASED_MESSAGE.getMessage(), numberOfLottoPurchased));
    }

    public static void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
    }
}
