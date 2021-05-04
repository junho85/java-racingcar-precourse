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

    public Integer getPosition(Car car) {
        return status.get(car);
    }

    public void addPosition(Car car) {
        Integer position = getPosition(car);
        position++;
        status.put(car, position);
    }
}
