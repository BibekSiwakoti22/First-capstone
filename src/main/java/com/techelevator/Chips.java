package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Products {

    private String type = "Chip";

    public Chips(String itemName, BigDecimal itemPrice, String type) {
        super(itemName, itemPrice, type);
    }

//    @Override
//    public String message() {
//        return "Crunch Crunch, Yum!";
//    }
//
//    @Override
//    public BigDecimal updatingCurrentMoney() {
//        return  getCurrentMoney().subtract(getItemPrice());
//    }

    public String getType() {
        return type;
    }
}
