import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public Set<Car> getWinners() {
        Map<Integer, Set<Car>> carByPosition = new HashMap<>();
        int maxPosition = 0;

        for (Car car : status.keySet()) {
            Integer position = getPosition(car);

            Set<Car> cars = carByPosition.getOrDefault(position, new HashSet<>());
            cars.add(car);
            carByPosition.put(position, cars);
            maxPosition = Math.max(maxPosition, position);
        }

        return carByPosition.get(maxPosition);
    }
}
