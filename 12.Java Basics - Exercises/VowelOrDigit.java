package Exercises;

import java.util.Scanner;

public class VowelOrDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char symbol = scanner.nextLine().charAt(0);

        if (Character.isDigit(symbol)) {
            System.out.println("digit");
        } else if (symbol == 'a' ||
                symbol == 'e' ||
                symbol == 'o' ||
                symbol == 'u' ||
                symbol == 'i') {
            System.out.println("vowel");
        } else {
            System.out.println("other");
        }
    }
}
