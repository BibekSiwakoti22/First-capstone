package com.techelevator;

public class Chips extends Products implements purchasable {


    public Chips(String itemName, double itemPrice) {
        super(itemName, itemPrice);
    }

    @Override
    public String message() {
        return "Crunch Crunch, Yum!";
    }

    @Override
    public double updatingCurrentMoney() {
        return  - getItemPrice();
    }
}
