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
        double [] old_pos = lorry.getPosition();
        lorry.gas

    }

    @Test
    void moveWithCars(){

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
        double oldAngle = lorry.getAngle();
        lorry.lower();
        boolean angleState = oldAngle > lorry.getAngle();
        Assertions.assertTrue(angleState);
    }

    @Test
    void getAngle() {
    }

    @Test
    void getLoadedCars() {
    }

    @Test
    void load() {
    }

    @Test
    void unload() {
        ArrayList<Car> oldList = lorry.getLoadedCars();
        lorry.load(Saa);

    }
}