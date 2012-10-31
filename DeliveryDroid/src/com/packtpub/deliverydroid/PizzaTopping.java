package com.packtpub.deliverydroid;

public class PizzaTopping {
    final String name;
    ToppingQuantity quantity;

    public PizzaTopping(String name) {
        this.name = name;
        this.quantity = ToppingQuantity.OFF;
    }
}
