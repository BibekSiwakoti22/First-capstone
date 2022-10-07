package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// Decrease inventory from 5 when purchasing
// Create message for if sold out
// Unit Testing
public class VendingMachine {

    private static BigDecimal currentMoney = BigDecimal.valueOf(2);


    static Scanner keyboard = new Scanner(System.in);
    static Map<String, Products> inventoryMap = new HashMap<>();
    static String pathIn = "C:\\Users\\Student\\workspace\\capstones\\java-purple-minicapstonemodule1-team4\\vendingmachine.csv";
    static File vending = new File(pathIn);

    public static void createInventory(){
        try (FileReader inventory = new FileReader(vending);
             Scanner fileScanner = new Scanner(vending)) {
            String line = "";
            while (fileScanner.hasNextLine()){
                line = fileScanner.nextLine();
                String[] productValues = line.split("\\|");
                String slot = productValues[0];
                String itemName = productValues[1];
                double tempPrice = Double.parseDouble(productValues[2]);
                BigDecimal price = BigDecimal.valueOf(tempPrice);
                String type = productValues[3];
                Products temp = null;
                if (type.equals("Gum")){
                    Gum newGum = new Gum(itemName, price, type);
                    temp = newGum;
                }
                else if(type.equals("Chip")){
                    Chips newChips = new Chips(itemName, price, type);
                    temp = newChips;
                }
                else if (type.equals("Drink")){
                    Drinks newDrink = new Drinks(itemName, price, type);
                    temp = newDrink;
                }
                else if (type.equals("Candy")){
                    Candy newCandy = new Candy (itemName, price, type);
                    temp = newCandy;
                }
                inventoryMap.put(slot, temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static BigDecimal feedMoney(){
        try {
            System.out.println("Your current money is " + getCurrentMoney());
            System.out.println("How much money do you want to feed?");
            BigDecimal input = keyboard.nextBigDecimal();

            currentMoney = getCurrentMoney().add(input);

        } catch (NullPointerException n){
            n.printStackTrace();
        } finally {
            return currentMoney;
        }
    }

    public static void selectProduct(){
        createInventory();
        printInventory();

        System.out.println("Input key of item to purchase");
        String input = keyboard.nextLine();
        currentMoney = getCurrentMoney().subtract(inventoryMap.get(input).getItemPrice());
        System.out.println(currentMoney);

        if(inventoryMap.get(input).getType().equals("Chip")){
            System.out.println("Crunch Crunch, Yum!");
        }
        else if(inventoryMap.get(input).getType().equals("Drink")) {
            System.out.println("Glug Glug, Yum!");
        }
        else if(inventoryMap.get(input).getType().equals("Gum")) {
            System.out.println("Chew Chew, Yum!");
        }
        else if(inventoryMap.get(input).getType().equals("Candy")) {
            System.out.println("Munch Munch, Yum!");
        }
        }


    public static void printInventory(){
        createInventory();
        for (String itemKey : inventoryMap.keySet()){
            System.out.println(itemKey + " | " + inventoryMap.get(itemKey).getItemName() + " | " + inventoryMap.get(itemKey).getItemPrice() + " | " + inventoryMap.get(itemKey).getType());
        }
    }

    public static BigDecimal getCurrentMoney() {
        return currentMoney;
    }
}
