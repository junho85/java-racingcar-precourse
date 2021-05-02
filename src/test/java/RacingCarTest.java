import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    void parseCarNames() {
        RacingCar racingCar = new RacingCar();
        List<String> carNames = racingCar.parseCarNames("pobi,crong,honux");

        assertThat(carNames)
                .as("check that list have elements split by ','")
                .containsExactly("pobi", "crong", "honux");
    }

    @Test
    void parseCarNames_check_max_length_5() {
        assertThatExceptionOfType(InvalidParameterException.class).isThrownBy(() -> {
            RacingCar racingCar = new RacingCar();
            racingCar.parseCarNames("pobiiii,crong,honux");
        });
    }
}