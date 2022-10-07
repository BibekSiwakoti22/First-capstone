package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Products{

    private String type = "Candy";

    public Candy(String itemName, BigDecimal itemPrice, String type) {
        super(itemName, itemPrice, type);
    }

//    @Override
//    public static String message() {
//        return "Munch Munch, Yum!";
//    }

    public String getType() {
        return type;
    }
}
