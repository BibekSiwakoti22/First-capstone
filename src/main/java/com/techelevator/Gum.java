package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Products{

    private String type = "Gum";

    public Gum(String itemName, BigDecimal itemPrice, String type) {
        super(itemName, itemPrice, type);
    }

//    @Override
//    public String message() {
//        return "Chew Chew, Yum!";
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
