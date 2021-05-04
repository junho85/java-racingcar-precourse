import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RacingCar {
    private Scanner scanner = new Scanner(System.in);
    private Turns turns;
    private RacingStatus racingStatus;

    public void init() {
        turns = new Turns();
        racingStatus = new RacingStatus();
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
            Car car = new Car();
            car.setName(carName);
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

    private String printScore(Integer score) {
        String result = "";
        for (int i = 0; i < score; i++) {
            result += "-";
        }
        return result;
    }

    private void racing() {
        Map<Car, Integer> status = racingStatus.getStatus();

        for (Car car : status.keySet()) {
            racingStatus.addScore(car);
            System.out.printf("%s : %s%n", car.getName(), printScore(racingStatus.getScore(car)));
        }
        System.out.println();
    }

    private void printResult() {
        System.out.println("pobi, honux가 최종 우승했습니다.");
    }

    public void run() {
        inputCarNames();
        inputTurns();
        racingAllTurns();
        printResult();
    }
}
