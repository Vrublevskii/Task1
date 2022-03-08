package worker;

import constants.CoffeeContainers;
import entities.Truck;
import entities.coffee.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TruckWorkerTest {

    TruckWorker truckWorker;
    Coffee arusha;
    Coffee blueMountain;
    Coffee java;
    Coffee sagada;
    List<Coffee> cargo;


    @Before
    public void beforeTest() {
        truckWorker = new TruckWorker(new Truck(900));
        arusha = new Arusha(97, CoffeeContainers.ONE_PORTION_BAG, 97);      //1 - цена за вес
        blueMountain = new BlueMountain(965, CoffeeContainers.JAR, 440);    //2
        java = new Java(990, CoffeeContainers.BEANS_IN_BAG, 490);           //2
        sagada = new Sagada(190, CoffeeContainers.BAG, 390);                //0.5
        cargo = truckWorker.getTruck().getCargo();
    }

    @Test
    public void addIntoTrackTest() {
        truckWorker.addIntoTrack(arusha);
        int cargo = truckWorker.getTruck().getCargo().size();
        Assert.assertEquals(1, cargo);
    }

    @Test
    public void addIntoTrackMaxTest() {
        truckWorker.addIntoTrack(arusha);
        truckWorker.addIntoTrack(blueMountain);
        int cargo = truckWorker.getTruck().getCargo().size();
        Assert.assertEquals(2, cargo);
    }

    @Test
    public void addIntoTrackMoreThenMaxTest() {
        truckWorker.addIntoTrack(arusha);
        truckWorker.addIntoTrack(blueMountain);
        truckWorker.addIntoTrack(java);
        Assert.assertEquals(2, cargo.size());
        Assert.assertEquals("Arusha", cargo.get(0).getSort());
        Assert.assertEquals("Blue Mountain", cargo.get(1).getSort());
    }

    @Test
    public void addIntoTrackMoreThenMaxThenMoreTest() {
        truckWorker.addIntoTrack(blueMountain);
        truckWorker.addIntoTrack(java);
        truckWorker.addIntoTrack(arusha);
        Assert.assertEquals(2, cargo.size());
        Assert.assertEquals("Blue Mountain", cargo.get(0).getSort());
        Assert.assertEquals("Arusha", cargo.get(1).getSort());
    }

    @Test
    public void searchCargoTest(){
        truckWorker.addIntoTrack(arusha);
        truckWorker.addIntoTrack(blueMountain);
        ArrayList<Coffee> coffees = truckWorker.searchCargo(1, 1);
        Assert.assertEquals(1, coffees.size());
        Assert.assertEquals("Arusha", coffees.get(0).getSort());
    }

    @Test
    public void sort(){
        truckWorker.addIntoTrack(arusha);
        truckWorker.addIntoTrack(blueMountain);
        Collections.sort(cargo);
        Assert.assertEquals("Blue Mountain", cargo.get(0).getSort());
        Assert.assertEquals("Arusha", cargo.get(1).getSort());
    }

}
