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

    public int getCargoLimit() {
        return cargoWeightLimit;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void addCargoWeight(int cargoWeight) throws RuntimeException {
        if (this.cargoWeight + cargoWeight <= this.cargoWeightLimit) {
            this.cargoWeight += cargoWeight;
        } else {
            throw new RuntimeException();
        }
    }
}
