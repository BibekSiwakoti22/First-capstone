package com.techelevator;

public class Gum extends Products implements purchasable{
    public Gum(String itemName, double itemPrice) {
        super(itemName, itemPrice);
    }

    @Override
    public String message() {
        return "Chew Chew, Yum!";
    }

    @Override
    public double updatingCurrentMoney() {
        return 0;
    }
}
