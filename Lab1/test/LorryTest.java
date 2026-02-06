import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LorryTest {
    Lorry lorry = new Lorry();
    Saab95 saab = new Saab95();
    Volvo240 volvo = new Volvo240();

    @Test
    void moveWithoutCars() {
        ArrayList<Double> old_pos = lorry.getPosition();
        lorry.gas(0.5);
        lorry.move();
        ArrayList<Double> new_pos = lorry.getPosition();
    }

    @Test
    void moveWithCars(){

        //lorry.load(volvo);
        //lorry.load(saab);
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

    }

    @Test
    void unload() {
        ArrayList<ICar> oldList = lorry.getLoadedCars();
        lorry.unload();
    }

    @Test
    void load() {
        lorry.load(saab);
        lorry.load(volvo);
        ArrayList<ICar> newList = lorry.getLoadedCars();
        Assertions.assertEquals(2 , newList.size());
         //newList.

    }

    @Test
    void loadWhenFull() {
        lorry.load(saab);
    }
}