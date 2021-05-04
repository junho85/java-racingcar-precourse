import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCar {
    private Scanner scanner = new Scanner(System.in);
    private Turns turns;

    public void init() {
        turns = new Turns();
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
        // TODO
    }

    private void inputTurns() {
        System.out.println("시도할 회수는 몇회인가요?");
        final int turns = Integer.parseInt(scanner.nextLine());
        this.turns.setTurns(turns);
    }

    private void racing() {
        // TODO
    }

    private void printResult() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < 5; i++) {
            System.out.println("pobi : -----");
            System.out.println("crong : ----");
            System.out.println("honux : -----");
            System.out.println();
        }
        System.out.println("pobi, honux가 최종 우승했습니다.");
    }

    public void run() {
        inputCarNames();
        inputTurns();
        racing();
        printResult();
    }
}
