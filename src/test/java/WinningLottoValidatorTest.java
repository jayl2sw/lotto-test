import exception.DuplicateNumberException;
import exception.IllegalLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.validator.WinningLottoValidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoValidatorTest {

    @DisplayName("입력된 당첨 숫자의 개수가 알맞지 않을 경우 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
    void validateThrowIllegalArgumentExceptionTest(String inputWrongSize) {
        assertThrows(IllegalLengthException.class, () -> WinningLottoValidator.validate(inputWrongSize));

    }

    @DisplayName("입력된 숫자가 중복될 경우 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 3, 5, 6", "2, 2, 2, 2, 2, 2"})
    void validateDuplicateThrowIllegalArgumentExceptionTest(String inputDuplicate) {
        assertThrows(DuplicateNumberException.class, () -> WinningLottoValidator.validate(inputDuplicate));
    }


    @DisplayName("입력된 숫자셋이 정상적일때 통과 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "2, 4, 6, 8, 10, 12"})
    void validateDoesNotThrowAnyExceptionTest(String inputCorrect) {
        assertDoesNotThrow(() -> WinningLottoValidator.validate(inputCorrect));
    }

}
