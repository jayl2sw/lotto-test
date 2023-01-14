package domain;

import util.validator.SingleNumberValidator;

public class GeneralNumber {
    // Wrapper 도메인은 생성자로 생성하고 final을 붙여준다.
    protected final int number;

    public GeneralNumber(String input) {
        SingleNumberValidator.validate(input);
        number = Integer.parseInt(input);
    }
}
