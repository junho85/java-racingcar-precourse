import java.util.Scanner;

public class RacingCar {
    private Scanner scanner = new Scanner(System.in);

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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String inputNames = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        final int tryNum = Integer.parseInt(scanner.nextLine());
        racing();
        printResult();
    }
}
