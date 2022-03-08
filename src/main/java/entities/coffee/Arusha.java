package entities.coffee;

import constants.CoffeeContainers;

@SuppressWarnings("unused")
public class Arusha extends Coffee {

    public Arusha(double price, CoffeeContainers coffeeContainers, int weightCoffee) {
        super(price, "Arusha", coffeeContainers, weightCoffee);
    }
}
