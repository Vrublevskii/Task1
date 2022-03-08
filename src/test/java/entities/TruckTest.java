package entities;

import constants.CoffeeContainers;
import entities.coffee.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class TruckTest {

    Truck truck;
    Coffee arusha;
    Coffee blueMountain;
    Coffee java;
    Sagada sagada;

    @Before
    public void beforeTest(){
        truck = new Truck(1000);
        arusha = new Arusha(97, CoffeeContainers.ONE_PORTION_BAG, 97);
        blueMountain = new BlueMountain(965, CoffeeContainers.JAR, 440);
        java = new Java(990, CoffeeContainers.BEANS_IN_BAG, 490);
        sagada = new Sagada(190, CoffeeContainers.BAG, 390);
    }

    @Test
    public void addCargoWeightLessThenMaxTest(){
        truck.addCargoWeight(arusha);
        truck.addCargoWeight(blueMountain);
        Assert.assertEquals(600, truck.getCargoWeight());
    }

    @Test(expected = RuntimeException.class)
    public void addCargoWeightMoreThenMaxTest(){
        truck.addCargoWeight(arusha);
        truck.addCargoWeight(blueMountain);
        truck.addCargoWeight(java);
        truck.addCargoWeight(sagada);
    }

}
