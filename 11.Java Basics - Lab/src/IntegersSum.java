import java.util.Arrays;
import java.util.Scanner;

public class IntegersSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] nums = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        if (!checkNumbers(nums[0], nums[1], nums[2])
                && !checkNumbers(nums[0], nums[2], nums[1])
                && !checkNumbers(nums[1], nums[2], nums[0])) {
            System.out.println("No");
        }
    }

    private static boolean checkNumbers(int first, int second, int sum) {
        if (first + second != sum) {
            return false;
        }
        if (first > second) {
            int temp = first;
            first = second;
            second = temp;
        }
        System.out.printf("%d + %d = %d", first, second, sum);
        return true;
    }
}
