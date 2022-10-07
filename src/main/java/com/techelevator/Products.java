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
    private final int MAX_AMOUNT = 5;
    private String type;

    public Products(String itemName, BigDecimal itemPrice, String type) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.type = type;
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
