import java.util.Arrays;
import java.util.Scanner;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbs = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(numbs);

        for (int i = numbs.length - 1; i >= 0; i--) {
            if (i == numbs.length - 4) {
                break;
            }
            System.out.println(numbs[i]);
        }
    }
}