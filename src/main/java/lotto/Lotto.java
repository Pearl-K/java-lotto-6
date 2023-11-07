package lotto;

import java.util.Collections;
import java.util.List;

import static lotto.LottoConstant.MIN_NUMBER;
import static lotto.LottoConstant.MAX_NUMBER;
import static lotto.LottoConstant.BONUS_NUMBER_COUNT;
import static lotto.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.LottoErrorMessage.INVALID_NUMBER_COUNT;
import static lotto.LottoErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.LottoErrorMessage.DUPLICATE_NUMBER;
import static lotto.LottoErrorMessage.INVALID_BONUS_NUMBER_COUNT;
import static lotto.LottoErrorMessage.INVALID_BONUS_NUMBER_RANGE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_COUNT.getMessage());
        }
    }

}
