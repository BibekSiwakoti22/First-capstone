package com.techelevator;

import java.util.Scanner;

public class MainMenu  {


    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        VendingMachine vm = new VendingMachine(keyboard);
        boolean running = true;
        while (running) {
            System.out.println("Welcome to Tech Elevator Vending Machine");
            System.out.println("Please enter 1 To Display Vending Machine Items");
            System.out.println("Please enter 2 To Purchase");
            System.out.println("Please enter 3 To  Exit");
            String input = keyboard.nextLine();

            if (input.equals("1")){
               vm.printInventory();
            }

            if(input.equals("2")){

                boolean purchasing = true;
                while(purchasing) {
                    System.out.println("Your current money is " + vm.getCurrentMoney());
                    System.out.println("Choose a option from below.");
                    System.out.println("(1) Feed Money");
                    System.out.println("(2) Select Product");
                    System.out.println("(3) Finish Transaction");

                    String purchaseInput = keyboard.nextLine();

                    if (purchaseInput.equals("1")){
                        vm.feedMoney();
                    }

                    if (purchaseInput.equals("2")){
                        vm.selectProduct();
                    }

                    if (purchaseInput.equals("3")) {
                        System.out.println("Your change is " + vm.getCurrentMoney());
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
