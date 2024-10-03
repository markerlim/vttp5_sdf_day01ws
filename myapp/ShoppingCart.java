package myapp;

import java.io.Console;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ShoppingCart {

    public static List<String> cart = new ArrayList<>();

    public static void main(String[] args) {
        Console cons = System.console();
        String input = cons.readLine("Welcome to your shopping cart\n");
        String choices = "";
        String options = "";

        while (true) {
            Scanner newScan = new Scanner(input);
            choices = newScan.next();

            if (choices.toLowerCase().equals("list")) {
                listItems();
            } else if (choices.toLowerCase().equals("add")) {
                options = newScan.nextLine();
                addItems(options);
            } else if (choices.toLowerCase().equals("delete")) {
                options = newScan.nextLine();
                deleteItems(options);
            } else if (!(choices.toLowerCase().equals("list")) && !(choices.toLowerCase().equals("add")) && !(choices.toLowerCase().equals("delete"))) {
                System.out.println("Function does not exist");
            };
            newScan.close();
            input = cons.readLine();
            
        }
    }

    public static void listItems() {
        if (cart.size() == 0) {
            System.out.println("Your cart is empty");
        } else {
            for (int i = 0; i < cart.size(); i++) {
                System.out.printf("%d. %s\n", i, cart.get(i));
            }
        }
    }

    public static void addItems(String options) {
        String[] newChoice = options.trim().split(",");
        Boolean duplicates;
        for (int i = 0; i < newChoice.length; i++) {
            duplicates = false;
            for (int k = 0; k < cart.size(); k++) {
                if (newChoice[i].trim().equals(cart.get(k))) {
                    duplicates = true;
                    break;
                }
            }
            if (duplicates) {
                System.out.println("You have " + newChoice[i].trim() + " in your cart");
                continue;
            }
            cart.add(newChoice[i].trim());
            System.out.println(newChoice[i].trim() + " added to cart");
        }
    }

    public static void deleteItems(String input) {
        String delIndex = input.trim();
        Integer delInt = Integer.parseInt(delIndex);
        if (delInt < cart.size()) {
            System.out.println(cart.get(delInt) + " removed from cart");
            cart.remove(cart.get(delInt));
        } else {
            System.out.println("Incorrect item index");
        }
    }
}
