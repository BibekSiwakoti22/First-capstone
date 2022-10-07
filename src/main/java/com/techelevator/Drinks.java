package com.techelevator;

import java.math.BigDecimal;

public class Drinks extends Products{

   private String type = "Drink";

    public Drinks(String itemName, BigDecimal itemPrice, String type) {
        super(itemName, itemPrice, type);
    }

//    @Override
//    public String message() {
//        return "Glug Glug, Yum!";
//    }
//
//    @Override
//    public BigDecimal updatingCurrentMoney() {
//        return null;
//    }

    public String getType() {
        return type;
    }
}
