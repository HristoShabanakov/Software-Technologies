package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArr = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int count = 0;
        for (int i = 0; i < numsArr.length; i++) {
            int[] leftElements = Arrays.stream(numsArr).limit(i).toArray();
            int[] rightElements = Arrays.stream(numsArr).skip(i + 1).toArray();

            if (Arrays.stream(leftElements).sum() == Arrays.stream(rightElements).sum()) {
                System.out.println(i);
                count++;
            }
        }
        if (count == 0)
            System.out.println("no");
    }
}
