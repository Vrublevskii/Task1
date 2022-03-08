package entities.coffee;

import constants.CoffeeContainers;

@SuppressWarnings("unused")
public class BlueMountain extends Coffee {

    public BlueMountain(double price, CoffeeContainers coffeeContainers, int weightCoffee) {
        super(price, "Blue Mountain", coffeeContainers, weightCoffee);
    }
}
