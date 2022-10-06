package com.techelevator;

public class Drinks extends Products implements purchasable{
    public Drinks(String itemName, double itemPrice) {
        super(itemName, itemPrice);
    }

    @Override
    public String message() {
        return "Glug Glug, Yum!";
    }

    @Override
    public double updatingCurrentMoney() {
        return 0;
    }
}
