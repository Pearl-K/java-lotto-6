package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoConstant.LOTTO_PRICE;
import static lotto.view.ViewErrorMessage.INPUT_LOTTO_PURCHASE_MONEY_MESSAGE;
import static lotto.view.ViewErrorMessage.INPUT_LOTTO_WINNING_NUMBERS_MESSAGE;
import static lotto.view.ViewErrorMessage.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.view.ViewErrorMessage.SEPARATOR;
import static lotto.view.ViewErrorMessage.ERROR_MESSAGE_HEADER;
import static lotto.view.ViewErrorMessage.ERROR_INVALID_PRICE;
import static lotto.view.ViewErrorMessage.ERROR_INPUT_IS_NOT_NUMBER;
import static lotto.view.ViewErrorMessage.ERROR_INVALID_INPUT;


public class InputView {

    private InputView() {
    }

    public static int inputLottoPurchaseMoney() {
        System.out.println(INPUT_LOTTO_PURCHASE_MONEY_MESSAGE);
        return getUserNumberInput();
    }

    public static List<Integer> inputLottoWinningNumber() {
        try {
            System.out.println(INPUT_LOTTO_WINNING_NUMBERS_MESSAGE);
            return getUserNumberListInput();
        } catch (RuntimeException runtimeException) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER.getMessage() + ERROR_INVALID_INPUT.getMessage());
        }
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return getUserNumberInput();
    }

    private static int getUserNumberInput() {
        String userInput = Console.readLine();
        validateUserNumberInput(userInput);
        return Integer.parseInt(userInput);
    }

    private static List<Integer> getUserNumberListInput() {
        String userInput = Console.readLine();
        List<String> winningNumber = Arrays.asList(userInput.split(SEPARATOR.getMessage()));

        return winningNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateUserNumberInput(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER.getMessage() + ERROR_INPUT_IS_NOT_NUMBER.getMessage());
        }
    }
}