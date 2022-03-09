package services;

import constants.CoffeeContainers;
import entities.Truck;
import entities.coffee.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Collections;
import java.util.List;

public class TruckServiceTest {

    TruckService truckService;
    Coffee arusha;
    Coffee blueMountain;
    Coffee java;
    Coffee sagada;
    List<Coffee> cargo;


    @Before
    public void beforeTest() {
        truckService = new TruckService(new Truck(900));
        arusha = new Arusha(97, CoffeeContainers.ONE_PORTION_BAG, 97);      //1 - цена за вес
        blueMountain = new BlueMountain(965, CoffeeContainers.JAR, 440);    //2
        java = new Java(990, CoffeeContainers.BEANS_IN_BAG, 490);           //2
        sagada = new Sagada(190, CoffeeContainers.BAG, 390);                //0.5
        cargo = truckService.getTruck().getCargo();
    }

    @Test
    public void addIntoTrackTest() {
        truckService.addIntoTrack(arusha);
        int cargo = truckService.getTruck().getCargo().size();
        Assert.assertEquals(1, cargo);
    }

    @Test
    public void addIntoTrackMaxTest() {
        truckService.addIntoTrack(arusha);
        truckService.addIntoTrack(blueMountain);
        int cargo = truckService.getTruck().getCargo().size();
        Assert.assertEquals(2, cargo);
    }

    @Test
    public void addIntoTrackMoreThenMaxTest() {
        truckService.addIntoTrack(arusha);
        truckService.addIntoTrack(blueMountain);
        truckService.addIntoTrack(java);
        Assert.assertEquals(2, cargo.size());
        Assert.assertEquals("Arusha", cargo.get(0).getSort());
        Assert.assertEquals("Blue Mountain", cargo.get(1).getSort());
    }

    @Test
    public void addIntoTrackMoreThenMaxThenMoreTest() {
        truckService.addIntoTrack(blueMountain);
        truckService.addIntoTrack(java);
        truckService.addIntoTrack(arusha);
        Assert.assertEquals(2, cargo.size());
        Assert.assertEquals("Blue Mountain", cargo.get(0).getSort());
        Assert.assertEquals("Arusha", cargo.get(1).getSort());
    }

    @Test
    public void searchCargoTest(){
        truckService.addIntoTrack(arusha);
        truckService.addIntoTrack(blueMountain);
        List<Coffee> coffees = truckService.searchCargo(1, 1);
        Assert.assertEquals(1, coffees.size());
        Assert.assertEquals("Arusha", coffees.get(0).getSort());
    }

    @Test
    public void sort(){
        truckService.addIntoTrack(arusha);
        truckService.addIntoTrack(blueMountain);
        Collections.sort(cargo);
        Assert.assertEquals("Blue Mountain", cargo.get(0).getSort());
        Assert.assertEquals("Arusha", cargo.get(1).getSort());
    }

}
