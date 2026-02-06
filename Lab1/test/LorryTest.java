import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LorryTest {
    Lorry lorry = new Lorry();
    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();
    Scania scania = new Scania();

    @Test
    void moveWithoutCars() {
        ArrayList<Double> old_pos = lorry.getPosition();
        lorry.gas(0.5);
        lorry.move();
        ArrayList<Double> new_pos = lorry.getPosition();
    }

    @Test
    void moveWithCars(){
        lorry.raise();
        lorry.load(volvo);
        lorry.load(saab);
        lorry.lower();
        lorry.gas(0.8);
        lorry.move();
        ArrayList<Double> lPos = lorry.getPosition();
        ArrayList<Double> vPos = volvo.getPosition();
        ArrayList<Double> sPos = saab.getPosition();

        Assertions.assertEquals(lPos, vPos);
        Assertions.assertEquals(lPos, sPos);
    }

    @Test
    void raise() {
        double oldAngle = lorry.getAngle();
        lorry.raise();
        boolean angleState = oldAngle < lorry.getAngle();
        Assertions.assertTrue(angleState);
    }

    @Test
    void lower() {
        lorry.raise();
        double oldAngle = lorry.getAngle();
        lorry.lower();
        boolean angleState = oldAngle > lorry.getAngle();
        Assertions.assertTrue(angleState);
    }

    @Test
    void getLoadedCars() {
        lorry.raise();
        lorry.load(volvo);
        lorry.load(saab);
        ArrayList<ICar> loaded = new ArrayList<>(2);
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
        ArrayList<ICar> oldList = new ArrayList<>(lorry.getLoadedCars());
        oldList.removeLast();
        lorry.unload();
        Assertions.assertEquals(oldList.size(), lorry.getLoadedCars().size());
    }

    @Test
    void load() {
        lorry.raise();
        lorry.load(saab);
        lorry.load(volvo);
        ArrayList<ICar> newList = lorry.getLoadedCars();
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