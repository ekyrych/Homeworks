package com.kyrychenko.xml;

public class BeerIngredient {
    private String name;
    private double amount;

    public BeerIngredient() {
    }

    public BeerIngredient(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BeerIngredient{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
