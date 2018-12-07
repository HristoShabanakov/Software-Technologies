package Exercises;

import java.util.Scanner;

public class FitStringIn20Chars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        if (line.length() >= 20) {
            System.out.println(line.substring(0, 20));
        } else {
            //String result = String.format("%1$-20s", line).replace(" ", "*");
            //System.out.println(result);
            System.out.print(line);
            System.out.println(repeatString("*", 20 - line.length()));
        }
    }

    public static String repeatString(String symbol, int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += symbol;
        }
        return result;
    }
}