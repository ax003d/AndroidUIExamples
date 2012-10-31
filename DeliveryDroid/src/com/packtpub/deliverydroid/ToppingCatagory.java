package com.packtpub.deliverydroid;

class ToppingCatagory {
    final String name;
    private final PizzaTopping[] toppings;
    
    public ToppingCatagory(String name, PizzaTopping... toppings) {
        this.name = name;
        this.toppings = toppings;
    }
    
    public PizzaTopping[] getToppings() {
    	return toppings;
    }
}