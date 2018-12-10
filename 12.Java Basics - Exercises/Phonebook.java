package Exercises;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String, String> phonebooks = new HashMap<String, String>();

        while (!input.equals("END")) {
            String[] inputArgs = input.split(" ");
            String name = inputArgs[1];

            switch (inputArgs[0]) {
                case "S":
                    if (phonebooks.containsKey(name)) {
                        String userPhone = phonebooks.get(name);
                        System.out.printf("%s -> %s%n", name, userPhone);
                    } else {
                        System.out.printf("Contact %s does not exist.%n", name);
                    }
                    break;
                case "A":
                    String phone = inputArgs[2];
                    phonebooks.put(name, phone);
                    break;
                default:
                    throw new NullPointerException();
            }
            input = scanner.nextLine();
        }
    }
}
