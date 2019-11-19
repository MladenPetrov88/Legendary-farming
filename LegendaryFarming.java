import com.sun.source.tree.Tree;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> neededItems = new TreeMap<>();
        neededItems.put("shards", 0);
        neededItems.put("fragments", 0);
        neededItems.put("motes", 0);
        Map<String, Integer> junkItems = new TreeMap<>();

        boolean isValid = false;

        while (!isValid) {
            String[] input = scanner.nextLine().toLowerCase().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String item = input[i + 1];
                if (neededItems.containsKey(item)) {
                    neededItems.put(item, neededItems.get(item) + quantity);
                } else {
                    if (!junkItems.containsKey(item)) {
                        junkItems.put(item, quantity);
                    } else {
                        junkItems.put(item, junkItems.get(item) + quantity);
                    }
                }

                if (neededItems.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    int a = neededItems.get("shards") - 250;
                    neededItems.put("shards", a);
                    isValid = true;
                    break;
                } else if (neededItems.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    int a = neededItems.get("fragments") - 250;
                    neededItems.put("fragments", a);
                    isValid = true;
                    break;
                } else if (neededItems.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    int a = neededItems.get("motes") - 250;
                    neededItems.put("motes", a);
                    isValid = true;
                    break;
                }

            }
        }

        neededItems
                .entrySet()
                .stream()
                .sorted((a,b) -> {
                    if (b.getValue() + a.getValue() == 0) {
                        return a.getKey().compareTo(b.getKey());
                    } else {
                        return  b.getValue() - a.getValue();
                    }
                }).forEach(x -> System.out.println(x.getKey() + ": " + x.getValue()));

        junkItems
                .forEach((x,y) -> System.out.println(x + ": " + y));
    }
}

