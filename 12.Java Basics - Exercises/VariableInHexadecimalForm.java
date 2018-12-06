package Exercises;

import java.util.Scanner;

public class VariableInHexadecimalForm {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Integer outputDecimal = Integer.parseInt(input,16);
        System.out.println(outputDecimal);
    }
}
