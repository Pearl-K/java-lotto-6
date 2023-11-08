package lotto.domain;

import static lotto.domain.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoConstant.MAX_NUMBER;
import static lotto.domain.LottoConstant.MIN_NUMBER;
import static lotto.view.ViewErrorMessage.ERROR_INVALID_RANGE;
import static lotto.view.ViewErrorMessage.ERROR_MESSAGE_HEADER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class WinningResult {
    public void calculateWinningResult(List<List<Integer>> randomLottoNumbers, List<Integer> winners, int count){

        for (int i=0; i < count; i++){
            int winCount = 0;
            for (int j=0; j < LOTTO_NUMBER_COUNT.getValue(); j++){
                if (randomLottoNumbers.get(i).contains(winners.get(j))){
                    winCount++;
                }
            }
            if (winCount == LOTTO_NUMBER_COUNT.getValue()-1){

            }
        }
    }
}
