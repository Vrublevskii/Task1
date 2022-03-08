package entities;

import entities.coffee.Coffee;

import java.util.ArrayList;
import java.util.List;

public class Truck {

    private final List<Coffee> cargo = new ArrayList<>();

    private final int cargoWeightLimit;

    private int cargoWeight = 0;

    public Truck(int cargoLimit) {
        this.cargoWeightLimit = cargoLimit;
    }

    public List<Coffee> getCargo() {
        return cargo;
    }


    @SuppressWarnings("unused")
    public int getCargoLimit() {
        return cargoWeightLimit;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void addCargoWeight(Coffee coffee) throws RuntimeException {
        if (this.cargoWeight + coffee.getWeightWithContainer() <= this.cargoWeightLimit) {
            this.cargoWeight += coffee.getWeightWithContainer();
        } else {
            throw new RuntimeException();
        }
    }
}
