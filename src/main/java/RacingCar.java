import java.security.InvalidParameterException;
import java.util.*;

public class RacingCar {
    private Scanner scanner = new Scanner(System.in);
    private Turns turns;
    private RacingStatus racingStatus;
    private Random random;


    public void init() {
        turns = new Turns();
        racingStatus = new RacingStatus();
        random = new Random();
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new InvalidParameterException("car name must less than 6");
        }
    }

    public List<String> parseCarNames(String carNames) {
        List<String> result = new ArrayList<>();
        for (String name : carNames.split(",")) {
            validateCarName(name);
            result.add(name);
        }
        return result;
    }

    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = parseCarNames(scanner.nextLine());
        for (String carName : carNames) {
            Car car = new Car(carName);
            racingStatus.addCar(car);
        }
    }

    private void inputTurns() {
        System.out.println("시도할 회수는 몇회인가요?");
        final int turns = Integer.parseInt(scanner.nextLine());
        this.turns.setTurns(turns);
    }

    private void racingAllTurns() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < turns.getTurns(); i++) {
            racing();
        }
    }

    private String printPosition(Integer position) {
        String result = "";
        for (int i = 0; i < position; i++) {
            result += "-";
        }
        return result;
    }

    private void racing() {
        Map<Car, Integer> status = racingStatus.getStatus();

        for (Car car : status.keySet()) {
            goOrNot(car);
            System.out.printf("%s : %s%n", car.getName(), printPosition(racingStatus.getPosition(car)));
        }
        System.out.println();
    }

    private void goOrNot(Car car) {
        if (random.nextInt(10) >= 4)
            racingStatus.addPosition(car);
    }

    private void printResult() {
        Set<Car> winners = racingStatus.getWinners();
        List<String> winnersString = new ArrayList<>();
        for (Car winner : winners) {
            winnersString.add(winner.getName());
        }

        System.out.printf("%s가 최종 우승했습니다.\n", String.join(", ", winnersString));
    }

    public void run() {
        inputCarNames();
        inputTurns();
        racingAllTurns();
        printResult();
    }
}
