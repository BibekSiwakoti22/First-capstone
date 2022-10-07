package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {



    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Welcome to Tech Elevator Vending Machine");
            System.out.println("Please enter 1 To Display Vending Machine Items");
            System.out.println("Please enter 2 To Purchase");
            System.out.println("Please enter 3 To  Exit");
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
