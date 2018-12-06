package Exercises;

import java.util.Scanner;

public class BooleanVariable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean result = Boolean.valueOf(input);
        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
