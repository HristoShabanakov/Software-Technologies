package Exercises;

import java.util.Scanner;

public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        if (a.compareTo(b) > 0) {
            System.out.println(b.replace(" ", ""));
            System.out.println(a.replace(" ", ""));
        } else {
            System.out.println(a.replace(" ", ""));
            System.out.println(b.replace(" ", ""));
        }
    }
}