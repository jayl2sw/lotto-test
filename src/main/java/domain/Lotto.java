package domain;

import state.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static constant.Constant.*;

public class Lotto {

    private static final int START_INDEX = 0;
    private static final List<Integer> WHOLE_NUMBER = IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND).boxed().collect(Collectors.toList());

    private final List<Integer> numbers;

    public Lotto() {
        Collections.shuffle(WHOLE_NUMBER);
        List<Integer> numbersIn = new ArrayList<>(WHOLE_NUMBER.subList(START_INDEX,START_INDEX+LENGTH));
        Collections.sort(numbersIn);
        this.numbers = Collections.unmodifiableList(numbersIn);
    }

    public Lotto(String input) {
        this.numbers = Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    // 뭘 꼭 고치냐
    public Result getResult(WinningLotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> winningLottoNumbers = winningLotto.getWinningLottoNumbers();
        int count = (int) numbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
        if (count == 5 && isBonus(bonusNumber)) {
            return Result.FIVEBONUS;
        }

        return Result.of(count);
    }

    public boolean isBonus(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.number);
    }

    public String getLottoNumbers() {
        return numbers.toString();
    }
}
