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

    // validate 기능 부족함, min~max 범위와 중복 제거도 생각해야함
    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_COUNT.getMessage());
        }
    }

}
