package Exercises;
import java.util.Scanner;

public class IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer input = Integer.parseInt(scanner.nextLine());
        String hex = Integer.toString(input, 16).toUpperCase();
        String binary = Integer.toString(input, 2).toUpperCase();
        System.out.println(hex);
        System.out.println(binary);
    }
}

