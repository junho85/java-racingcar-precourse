import java.util.HashMap;
import java.util.Map;

public class RacingStatus {
    private Map<Car, Integer> status = new HashMap<>();

    public void addCar(Car car) {
        status.put(car, 0);
    }

    public Map<Car, Integer> getStatus() {
        return status;
    }

    public Integer getScore(Car car) {
        return status.get(car);
    }

    public void addScore(Car car) {
        Integer score = getScore(car);
        score++;
        status.put(car, score);
    }
}
