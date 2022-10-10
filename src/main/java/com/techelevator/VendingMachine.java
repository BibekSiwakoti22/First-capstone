package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// Unit Testing
// Log
public class VendingMachine  {

    private BigDecimal currentMoney = BigDecimal.valueOf(2);

    private Scanner keyboard;
    private Map<String, Products> inventoryMap = new HashMap<>();
    private String pathIn = "vendingmachine.csv";
    private File vending = new File(pathIn);

    public VendingMachine(Scanner keyboard) {
        this.keyboard = keyboard;
        createInventory();
    }

    public void createInventory() {
        try (FileReader inventory = new FileReader(vending);
             Scanner fileScanner = new Scanner(vending)) {
            String line = "";
            while (fileScanner.hasNextLine()) {
                line = fileScanner.nextLine();
                String[] productValues = line.split("\\|");
                String slot = productValues[0];
                String itemName = productValues[1];
                double tempPrice = Double.parseDouble(productValues[2]);
                BigDecimal price = BigDecimal.valueOf(tempPrice);
                String type = productValues[3];
                Products temp = null;
                if (type.equals("Gum")) {
                    Gum newGum = new Gum(itemName, price, type);
                    temp = newGum;
                } else if (type.equals("Chip")) {
                    Chips newChips = new Chips(itemName, price, type);
                    temp = newChips;
                } else if (type.equals("Drink")) {
                    Drinks newDrink = new Drinks(itemName, price, type);
                    temp = newDrink;
                } else if (type.equals("Candy")) {
                    Candy newCandy = new Candy(itemName, price, type);
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

    public BigDecimal feedMoney() {
        try {
            System.out.println("Your current money is " + getCurrentMoney());
            System.out.println("How much money do you want to feed?");
            BigDecimal input = keyboard.nextBigDecimal();

            currentMoney = getCurrentMoney().add(input);

        } catch (NullPointerException n) {
            n.printStackTrace();
        } finally {
            return currentMoney;
        }
    }

    public void selectProduct() {
        printInventory();

        System.out.println("Input key of item to purchase");
        String input = keyboard.nextLine();

        currentMoney = getCurrentMoney().subtract(inventoryMap.get(input).getItemPrice());
        if (currentMoney.doubleValue() < 0){
            System.out.println("Not enough money, sorry! Please feed money.");
            currentMoney = currentMoney.add(inventoryMap.get(input).getItemPrice());
        }
        else {System.out.println(currentMoney);}

        if (inventoryMap.get(input).getType().equals("Chip")) {
            if(inventoryMap.get(input).updateInventory()) {
                System.out.println("Crunch Crunch, Yum!");}
        } else if (inventoryMap.get(input).getType().equals("Drink")) {
            if(inventoryMap.get(input).updateInventory()){
            System.out.println("Glug Glug, Yum!");}
        } else if (inventoryMap.get(input).getType().equals("Gum")) {
            if(inventoryMap.get(input).updateInventory()){
            System.out.println("Chew Chew, Yum!");}
        } else if (inventoryMap.get(input).getType().equals("Candy")) {
            if(inventoryMap.get(input).updateInventory()){
            System.out.println("Munch Munch, Yum!");}
        }
    }

    public void printInventory(){
        for (String itemKey : inventoryMap.keySet()){
            System.out.println(itemKey + " | " + inventoryMap.get(itemKey).getItemName() + " | " + inventoryMap.get(itemKey).getItemPrice() + " | " + inventoryMap.get(itemKey).getType());
        }
    }

//    public void writeLogPurchase() {
//
//        String logPath = "Log.txt";
//        File logFile = new File(logPath);
//
//        try (PrintWriter logWriter = new PrintWriter(logFile); Scanner fileScanner = new Scanner(logFile)) {
//
//            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a"));
//            BigDecimal newMoney = getCurrentMoney().subtract(inventoryMap.get().getItemPrice());
//
//            logWriter.println("\n");
//
//            logWriter.println(dateTime + inventoryMap.get().getItemName() + input + inventoryMap.get().getItemPrice() + newMoney);
//
//
//        } catch (FileNotFoundException fnf) {
//            System.out.println(fnf);
//        }
//    }


    public BigDecimal getCurrentMoney() {
//        if(currentMoney.doubleValue() < 0){
//
//        }
        return currentMoney;
    }
}
