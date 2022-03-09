package services;

import entities.Truck;
import entities.coffee.Coffee;
import exeptions.OverloadException;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
public class TruckService {

    private final Truck truck;

    public TruckService(Truck truck) {
        this.truck = truck;
    }

    public Truck getTruck() {
        return truck;
    }

    public void addIntoTrack(Coffee coffee) {
        try {
            truck.addCargoWeight(coffee);
            truck.getCargo().add(coffee);
        } catch (OverloadException e) {
            System.out.flush();
            System.err.println("Not enough space");
            System.err.flush();
        }
    }

    public List<Coffee> searchCargo(double priceForWeightMin, double priceForWeightMax) {
        List<Coffee> selectedCoffee = new ArrayList<>();
        for (Coffee coffee : truck.getCargo()) {
            double priceForWeight = coffee.getPriceForWeight();
            if (priceForWeight >= priceForWeightMin && priceForWeight <= priceForWeightMax) {
                selectedCoffee.add(coffee);
            }
        }
        return selectedCoffee;
    }

}
