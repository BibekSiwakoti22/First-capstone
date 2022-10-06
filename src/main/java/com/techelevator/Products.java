package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Products {

    public static Scanner keyboard = new Scanner(System.in);

    private String itemName;
    private double itemPrice;
    private final double MAX_AMOUNT = 5;
    private static double currentMoney = 2;

    public Products(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Products(String itemName, double itemPrice, double currentMoney) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.currentMoney = currentMoney;
    }

    public static double feedMoney(){
        try {
            System.out.println("Your current money is " + getCurrentMoney());
            System.out.println("How much money do you want to feed?");
            double input = keyboard.nextDouble();

            currentMoney = getCurrentMoney() + input;

        } catch (NullPointerException n){
            n.printStackTrace();
        } finally {
            return currentMoney;
        }
    }

    public static void selectProduct(){
        String pathIn = "C:\\Users\\Student\\workspace\\capstones\\java-purple-minicapstonemodule1-team4\\vendingmachine.csv";
        File vending = new File(pathIn);

        try (FileReader inventory = new FileReader(vending);
             Scanner fileScanner = new Scanner(vending)) {
            Map<String, String> purchaseMap = new HashMap<>();
            String line = "";
            while (fileScanner.hasNextLine()){
                line = fileScanner.nextLine();
                purchaseMap.put(line.substring(0, 2), line.substring(3));
            }
            for (String itemKey : purchaseMap.keySet()){
                System.out.println(itemKey + "|" + purchaseMap.get(itemKey));
            }

            System.out.println("Input key of item to purchase");
            String input = keyboard.nextLine();

            String potentialPurchase = purchaseMap.get(input);
            String[] value = potentialPurchase.split("\\|");
            double price = Double.parseDouble(value[1]);
            currentMoney = getCurrentMoney() - price;
            System.out.println(currentMoney);


        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

    }

    public static void createInventory(){
        String pathIn = "C:\\Users\\Student\\workspace\\capstones\\java-purple-minicapstonemodule1-team4\\vendingmachine.csv";
        File vending = new File(pathIn);
        try (FileReader inventory = new FileReader(vending);
             Scanner fileScanner = new Scanner(vending)) {
            Map<String, String> inventoryMap = new HashMap<>();
            String line = "";
            while (fileScanner.hasNextLine()){
                line = fileScanner.nextLine();
                inventoryMap.put(line.substring(0, 2), line.substring(3));
            }
            for (String itemKey : inventoryMap.keySet()){
                System.out.println(itemKey + "|" + inventoryMap.get(itemKey));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double getCurrentMoney() {
        return currentMoney;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
