package Exercises;
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String reveresedString = new StringBuilder(input).reverse().toString();
        System.out.println(reveresedString);
    }
}
