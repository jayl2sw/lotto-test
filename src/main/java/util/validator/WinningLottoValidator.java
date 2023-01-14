package util.validator;

import exception.DuplicateNumberException;
import exception.IllegalLengthException;

import java.util.*;
import java.util.stream.Collectors;

import static constant.Constant.DELIMITER;
import static constant.Constant.LENGTH;

public class WinningLottoValidator {

    public static void validate(String input) {
        String[] splitInput = input.split(DELIMITER);
        validateLength(splitInput);

        Arrays.stream(splitInput).forEach(SingleNumberValidator::validate);
        List<Integer> numbers = Arrays.stream(splitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateDuplicate(numbers);
    }

    private static void validateLength(String[] inputs) {
        if(inputs.length != LENGTH) {
            throw new IllegalLengthException("잘못된 길이의 입력값입니다.");
        }
    }

    private static void validateDuplicate(List<Integer> inputs) {
        Set<Integer> distinctNumbers = new HashSet<>();
        inputs.stream().forEach(input -> distinctNumbers.add(input));
        if (distinctNumbers.size() != LENGTH) {
            throw new DuplicateNumberException("");
        }

    }

}
