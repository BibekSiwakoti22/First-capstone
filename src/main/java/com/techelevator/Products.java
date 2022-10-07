package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Products extends VendingMachine {

    private String itemName;
    private BigDecimal itemPrice;
    private String type;
    private int amount;

    public Products(String itemName, BigDecimal itemPrice, String type) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.type = type;
        this.amount = 5;
    }

    public boolean updateInventory(){
        int newAmount = getAmount() - 1;
        setAmount(newAmount);
        if(newAmount <= 0){
            System.out.println("Item is sold out, sorry!");
            return false;
        }
        return true;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
