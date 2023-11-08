package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import static lotto.domain.LottoConstant.MIN_NUMBER;
import static lotto.domain.LottoConstant.MAX_NUMBER;
import static lotto.domain.LottoConstant.LOTTO_NUMBER_COUNT;

public class LottoRandomNumberGenerator {
    public static List<List<Integer>> generateRandomNumbers(long count) {

        List<List<Integer>> randomLottoNumbers = new ArrayList<>();

        LongStream.range(0, count)
                .forEach(i -> {
                    List<Integer> randomNumbers = new ArrayList<>(
                            Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), LOTTO_NUMBER_COUNT.getValue()));
                    randomNumbers.sort(Integer::compareTo);
                    randomLottoNumbers.add(randomNumbers);
                });

        return randomLottoNumbers;
    }
}