package worker;

import entities.Truck;
import entities.coffee.Coffee;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ClassCanBeRecord")
public class TruckWorker {

    private final Truck truck;

    public TruckWorker(Truck truck) {
        this.truck = truck;
    }

    public Truck getTruck() {
        return truck;
    }

    public void addIntoTrack(Coffee coffee) {
        try {
            truck.addCargoWeight(coffee);
            truck.getCargo().add(coffee);
        } catch (RuntimeException e) {
            System.err.println("Not enough space");
        }
    }

    public ArrayList<Coffee> searchCargo(double priceForWeightMin, double priceForWeightMax) {
        ArrayList<Coffee> selectedCoffee = new ArrayList<>();
        for (Coffee coffee : truck.getCargo()) {
            double priceForWeight = coffee.getPriceForWeight();
            if (priceForWeight >= priceForWeightMin && priceForWeight <= priceForWeightMax) {
                selectedCoffee.add(coffee);
            }
        }
        return selectedCoffee;
    }

}
