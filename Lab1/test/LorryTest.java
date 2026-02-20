import MVC.Vehicles.CarsPackage.Components.ICar;
import MVC.Vehicles.TrucksPackage.Trucks.Lorry;
import MVC.Vehicles.TrucksPackage.Trucks.Scania;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import MVC.Vehicles.CarsPackage.Cars.Saab95;
import MVC.Vehicles.CarsPackage.Cars.Volvo240;

import java.util.ArrayList;
import java.util.List;

class LorryTest {
    Lorry lorry = new Lorry();
    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();
    Scania scania = new Scania();


    @Test
    void moveWithoutCars() {
        List<Double> old_pos = lorry.getPosition();
        lorry.gas(0.5);
        lorry.move();
        List<Double> new_pos = lorry.getPosition();
    }

    @Test
    void moveWithCars(){
        lorry.raise();
        volvo.updatePosition(0,0);
        saab.updatePosition(0,0);
        lorry.load(volvo);
        lorry.load(saab);
        lorry.lower();
        lorry.gas(0.8);
        lorry.move();
        List<Double> lPos = lorry.getPosition();
        List<Double> vPos = volvo.getPosition();
        List<Double> sPos = saab.getPosition();

        Assertions.assertEquals(lPos, vPos);
        Assertions.assertEquals(lPos, sPos);
    }

    @Test
    void raise() {
        lorry.raise();
        Assertions.assertTrue(lorry.getAngle());
    }

    @Test
    void lower() {
        lorry.raise();
        lorry.lower();
        Assertions.assertFalse(lorry.getAngle());
    }

    @Test
    void getLoadedCars() {
        lorry.raise();

        lorry.load(volvo);
        lorry.load(saab);
        List<ICar> loaded = new ArrayList<>(2);
        loaded.add(volvo);
        loaded.add(saab);

        Assertions.assertEquals(loaded, lorry.getLoadedCars());
    }

    @Test
    void unload1() {
        lorry.raise();
        lorry.load(volvo);
        lorry.load(saab);
        ICar unloadedCar = lorry.unload();
        Assertions.assertEquals(saab,unloadedCar);
    }

    @Test
    void unload2() {
        lorry.raise();
        lorry.load(volvo);
        lorry.load(saab);
        List<ICar> oldList = new ArrayList<>(lorry.getLoadedCars());
        oldList.removeLast();
        lorry.unload();
        Assertions.assertEquals(oldList.size(), lorry.getLoadedCars().size());
    }

    @Test
    void load() {
        lorry.raise();
        lorry.load(saab);
        lorry.load(volvo);
        List<ICar> newList = lorry.getLoadedCars();
        Assertions.assertEquals(2 , newList.size());
    }

    @Test
    void loadWhenFull() {
        lorry.raise();
        lorry.load(saab);
        lorry.load(saab);
        lorry.load(volvo);
        lorry.load(volvo);
        lorry.load(volvo);
        lorry.load(volvo);
        Assertions.assertEquals(2, lorry.getLoadedCars().size());
    }
}