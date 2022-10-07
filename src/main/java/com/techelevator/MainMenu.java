package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu extends Products {

    public MainMenu(String itemName, double itemPrice, double currentMoney) {
        super(itemName, itemPrice, currentMoney);
    }


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Input a choice from below as a single number");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");

            String input = keyboard.nextLine();

            if (input.equals("1")){
                createInventory();
            }

            if(input.equals("2")){

                boolean purchasing = true;
                while(purchasing) {
                    System.out.println("Your current money is " + getCurrentMoney());

                    System.out.println("Pick an option from below.");
                    System.out.println("(1) Feed Money");
                    System.out.println("(2) Select Product");
                    System.out.println("(3) Finish Transaction");

                    String purchaseInput = keyboard.nextLine();

                    if (purchaseInput.equals("1")){
                        feedMoney();
                    }

                    if (purchaseInput.equals("2")){
                        selectProduct();
                    }

                    if (purchaseInput.equals("3")) {
                        System.out.println("Your change is " + getCurrentMoney());
                        System.exit(0);
                    }
                }
            }

            if (input.equals("3")) {
                running = false;
            }
        }
    }
}
