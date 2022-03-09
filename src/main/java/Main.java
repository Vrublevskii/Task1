import constants.CoffeeContainers;
import entities.Truck;
import entities.coffee.Coffee;
import entities.coffee.Java;
import services.TruckService;
import java.util.Collections;
import java.util.List;

import static constants.CoffeeContainers.*;


public class Main {

    public static void main(String[] args) {
        Coffee java = new Java(100, BAG, 200);
        Coffee java1 = new Java(110, BAG, 200);
        Coffee java2 = new Java(120, JAR, 200);
        Truck truck = new Truck(2000);
        TruckService truckService = new TruckService(truck);


        truckService.addIntoTrack(java2);
        truckService.addIntoTrack(java);
        truckService.addIntoTrack(java1);


        List<Coffee> cargo = truckService.getTruck().getCargo();

        for (Coffee coffee : cargo) {
            System.out.println(coffee.getCoffeePrice());
            System.out.println(coffee.getPriceTotal());
        }

        Collections.sort(cargo);
        System.out.println(cargo.isEmpty());

        for (Coffee coffee : cargo) {
            System.out.println(coffee.getCoffeePrice());
        }
        System.out.println(truck.getCargoWeight());


        System.out.println(CoffeeContainers.JAR.getContainerName());

        System.out.println("\n\n\n");

        List<Coffee> coffees = truckService.searchCargo(0.50, 0.58);
        for (Coffee coffee : coffees) {
            System.out.println(coffee.getWeightWithContainer());
        }


    }

}
