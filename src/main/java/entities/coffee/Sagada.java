package entities.coffee;

import constants.CoffeeContainers;

@SuppressWarnings("unused")
public class Sagada extends Coffee{

    public Sagada(double price, CoffeeContainers coffeeContainers, int weightCoffee) {
        super(price, "Sagada", coffeeContainers, weightCoffee);
    }

}
