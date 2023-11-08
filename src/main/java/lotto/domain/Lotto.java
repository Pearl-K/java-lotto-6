package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoErrorMessage.INVALID_BONUS_NUMBER_COUNT;

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
