package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = 1;
        int bestCount = 0;
        int bestIndex = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > bestCount) {
                bestCount = count;
                bestIndex = i - count + 1;
            }
        }
        for (int i = bestIndex; i < bestIndex + bestCount; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
