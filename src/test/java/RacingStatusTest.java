import org.junit.jupiter.api.Test;

import java.util.Set;

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

    @Test
    void getWinners() {
        RacingStatus racingStatus = new RacingStatus();

        Car carA = new Car("a");
        Car carB = new Car("b");
        Car carC = new Car("c");

        racingStatus.addCar(carA);
        racingStatus.addCar(carB);
        racingStatus.addCar(carC);

        racingStatus.addPosition(carA);
        racingStatus.addPosition(carA);

        racingStatus.addPosition(carB);
        racingStatus.addPosition(carB);

        racingStatus.addPosition(carC);

        Set<Car> winners = racingStatus.getWinners();

        assertThat(winners)
                .containsExactly(carA, carB);
    }
}