
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SumsByTown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Map<String, Double> towns = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("[ |]+");
            String town = input[0];
            Double income = Double.parseDouble(input[1]);

            if (!towns.containsKey(town)) {
                towns.put(town, income);
            } else {
                Double value = towns.get(town) + income;
                towns.put(town, value);
            }
        }
        for (String town : towns.keySet()) {
            System.out.println(town + " -> " + towns.get(town));
        }
    }
}
