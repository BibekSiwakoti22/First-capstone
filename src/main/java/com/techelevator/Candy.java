package com.techelevator;

public class Candy extends Products implements purchasable{


    public Candy(String itemName, double itemPrice) {
        super(itemName, itemPrice);
    }

    @Override
    public String message() {
        return "Munch Munch, Yum!";
    }

    @Override
    public double updatingCurrentMoney() {
        return 0;
    }
}
