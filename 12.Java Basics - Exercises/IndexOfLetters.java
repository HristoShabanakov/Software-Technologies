package Exercises;

import java.util.Scanner;

public class IndexOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] letters = scanner.nextLine().toLowerCase().toCharArray();

        for (char letter : letters
        ) {
            int symbol = letter - 97;
            System.out.println(letter + " -> " + symbol);
        }
    }
}
