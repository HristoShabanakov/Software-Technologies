import java.util.Scanner;

public class SumTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = Double.parseDouble
                (scanner.nextLine());

        double secondNum = Double.parseDouble
                (scanner.nextLine());
        double sum = firstNum + secondNum;

        System.out.printf("%.2f", sum);
    }
}
