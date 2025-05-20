package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void startGrocery() {
        boolean running = true;
        while (running) {
            System.out.println("\n0 - Çıkış\n1 - Ürün Ekle\n2 - Ürün Çıkar");
            System.out.print("Seçiminizi girin: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "0":
                    running = false;
                    break;
                case "1":
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz (virgülle ayırarak): ");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;
                case "2":
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz (virgülle ayırarak): ");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 0, 1 veya 2 giriniz.");
            }
        }
        System.out.println("Uygulama sonlandırıldı.");
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();
            if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        sortList();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();
            groceryList.removeIf(existingItem -> existingItem.equalsIgnoreCase(trimmedItem));
        }
        sortList();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.stream()
                .anyMatch(item -> item.equalsIgnoreCase(product.trim()));
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Pazar Listesi:");
        for (String item : groceryList) {
            System.out.println("- " + item);
        }
    }

    private static void sortList() {
        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        set.addAll(groceryList);
        groceryList = new ArrayList<>(set);
    }
}