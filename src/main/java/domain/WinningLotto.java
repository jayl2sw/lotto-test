package domain;

import util.validator.WinningLottoValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constant.Constant.DELIMITER;

public class WinningLotto {
    private final List<Integer> winningLottoNumbers;

    public WinningLotto(String input) {
        WinningLottoValidator.validate(input);
        String[] splitInput = input.split(DELIMITER);
        this.winningLottoNumbers = Arrays.stream(splitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningLottoNumbers() {
        return new ArrayList<>(winningLottoNumbers);
    }
}

