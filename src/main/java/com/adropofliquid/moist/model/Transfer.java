package com.adropofliquid.moist.model;

public class Transfer {

    //maybe create table for history

    private String recipient;
    private double amount;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
