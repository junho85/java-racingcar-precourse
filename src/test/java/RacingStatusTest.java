import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingStatusTest {

    @Test
    void addCar() {
        RacingStatus racingStatus = new RacingStatus();

        Car car = new Car("a");
        racingStatus.addCar(car);

        assertThat(racingStatus.getPosition(car))
                .isZero();
    }

    @Test
    void getStatus() {
        RacingStatus racingStatus = new RacingStatus();

        Car car = new Car("a");
        racingStatus.addCar(car);

        assertThat(racingStatus.getStatus())
                .containsEntry(new Car("a"), 0);
    }

    @Test
    void getPosition() {
        RacingStatus racingStatus = new RacingStatus();

        Car car = new Car("a");
        racingStatus.addCar(car);

        assertThat(racingStatus.getPosition(car))
                .isZero();
    }

    @Test
    void addPosition() {
        RacingStatus racingStatus = new RacingStatus();

        Car car = new Car("a");
        racingStatus.addCar(car);
        racingStatus.addPosition(car);

        assertThat(racingStatus.getPosition(car))
                .isEqualTo(1);
    }
}