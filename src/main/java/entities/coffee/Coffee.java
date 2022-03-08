package entities.coffee;

import constants.CoffeeContainers;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public abstract class Coffee implements Comparable<Coffee> {

    private double coffeePrice;

    private double priceTotal;

    private final String sort;

    CoffeeContainers coffeeContainer;

    private final int weightCoffee;

    private final int weightWithContainer;

    private double priceForWeight;


    public Coffee(
            double coffeePrice,
            String sort,
            CoffeeContainers coffeeContainer,
            int weightCoffee
    ) {
        this.coffeePrice = coffeePrice;
        this.priceTotal = coffeePrice + coffeeContainer.getContainerPrice();
        this.sort = sort;
        this.coffeeContainer = coffeeContainer;
        this.weightCoffee = weightCoffee;
        this.weightWithContainer = weightCoffee + coffeeContainer.getContainerWeight();
        this.priceForWeight = priceTotal/weightWithContainer;
    }

    public double getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(double coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    public double getPriceTotal() {
        return priceTotal;
    }

    public String getSort() {
        return sort;
    }

    public String getContainer() {
        return coffeeContainer.name();
    }

    public int getWeightCoffee() {
        return weightCoffee;
    }

    public int getWeightWithContainer() {
        return weightWithContainer;
    }

    public double getPriceForWeight() {
        return priceForWeight;
    }

    @Override
    public int compareTo(@NotNull Coffee coffee) {
        double result = priceForWeight - coffee.getPriceForWeight();
        if (result < 0) {
            return 1;
        } else if (result > 0) {
            return -1;
        } else {
            return 0;
        }

    }

}
