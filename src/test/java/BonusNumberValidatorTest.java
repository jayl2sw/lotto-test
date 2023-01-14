import domain.WinningLotto;
import exception.DuplicateNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.validator.BonusNumberValidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberValidatorTest {

    @DisplayName("보너스 숫자가 당첨번호와 겹치면 예외 발생")
    @Test
    void duplicateTest() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        int bonusNumber = 1;
        assertThrows(DuplicateNumberException.class, () -> BonusNumberValidator.validate(winningLotto, bonusNumber));

    }

    @DisplayName("보너스 숫자가 당첨번호와 겹치면 예외 발생")
    @Test
    void notDuplicateTest() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        int bonusNumber = 7;
        assertDoesNotThrow(() -> BonusNumberValidator.validate(winningLotto, bonusNumber));

    }
}
