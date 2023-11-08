package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoConstant.LOTTO_PRICE;
import static lotto.domain.LottoConstant.MAX_NUMBER;
import static lotto.domain.LottoConstant.MIN_NUMBER;
import static lotto.view.ViewErrorMessage.ERROR_DUPLICATED_NUMBER;
import static lotto.view.ViewErrorMessage.ERROR_INVALID_RANGE;
import static lotto.view.ViewErrorMessage.ERROR_INVALID_SIZE;
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
        System.out.println(INPUT_LOTTO_PURCHASE_MONEY_MESSAGE.getMessage());
        return getUserNumberInput();
    }

    public static List<Integer> inputLottoWinningNumber() {
        try {
            System.out.println(INPUT_LOTTO_WINNING_NUMBERS_MESSAGE.getMessage());
            List<Integer> winners = getUserNumberListInput();
            int bonusNumber = inputBonusNumber();

            validateLottoSize(winners);
            validateNumberRange(winners, bonusNumber);
            validateDuplicatedNumber(winners, bonusNumber);

            winners.add(bonusNumber);
            return winners;
        } catch (RuntimeException runtimeException) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER.getMessage() + ERROR_INVALID_INPUT.getMessage());
        }
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.getMessage());
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

    private static void validateLottoSize(List<Integer> winners) {
        if (winners.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER.getMessage() + ERROR_INVALID_SIZE.getMessage());
        }
    }

    private static void validateNumberRange(List<Integer> winners, int bonusNumber) {
        winners.forEach(number -> {
            if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(ERROR_MESSAGE_HEADER.getMessage() + ERROR_INVALID_RANGE.getMessage());
            }
        });

        if (bonusNumber < MIN_NUMBER.getValue() || bonusNumber > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER.getMessage() + ERROR_INVALID_RANGE.getMessage());
        }
    }

    private static void validateDuplicatedNumber(List<Integer> winners, int bonusNumber) {
        if (winners.contains(bonusNumber) || hasDuplicates(winners)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEADER.getMessage() + ERROR_DUPLICATED_NUMBER.getMessage());
        }
    }

    private static boolean hasDuplicates(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }
}