import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import MVC.Vehicles.CarsPackage.Cars.Volvo240;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Volvo240Test {
    Volvo240 Volvo = new Volvo240();

    @Test
    public void getNrDoors() {
        Assertions.assertEquals(4, Volvo.getNrDoors(), "Number of doors should be 4");
    }

    @Test
    public void getEnginePower() {Assertions.assertEquals(100, Volvo.getEnginePower(), "Engine power should be 100");}

    @Test
    public void get_set_Color() {
        Volvo.setColor(Color.black);
        Assertions.assertEquals(Color.black, Volvo.getColor(), "Every cool car is Black...");
    }

    @Test
    public void startEngine() {
        Volvo.startEngine();
        Assertions.assertEquals(0.1,Volvo.getCurrentSpeed(), "When engine has started the speed should be 0.1");
    }

    @Test
    public void stopEngine() {
        Volvo.stopEngine();
        Assertions.assertEquals(0,Volvo.getCurrentSpeed(), "When engine is stopped it should be 0");
    }

    @Test
    public void speedFactor() {
        Assertions.assertEquals(1.25, Volvo.speedFactor(), "Expected speed factor");
    }

    @Test
    public void gas() {
        double oldSpeed = Volvo.getCurrentSpeed();
        Volvo.gas(0.5);
        double newSpeed = Volvo.getCurrentSpeed();
        boolean greaterThen = newSpeed > oldSpeed;
        Assertions.assertTrue(greaterThen, "The new speed should be bigger than the old speed");
    }

    @Test
    public void gas_on_max() {
        while ( Volvo.getCurrentSpeed() < Volvo.getEnginePower()){
            Volvo.gas(1);
        }
        Volvo.gas(0.5);
        double newSpeed = Volvo.getCurrentSpeed();
        Assertions.assertEquals(newSpeed, Volvo.getEnginePower());

    }

    @Test
    public void brakeOn0() {
        Volvo.gas(0.3);
        Volvo.stopEngine();
        Volvo.brake(0.1);
        Assertions.assertEquals(0, Volvo.getCurrentSpeed(), "Break with no speed");
    }

    @Test
    public void brake() {
        Volvo.gas(0.3);
        double oldSpeed = Volvo.getCurrentSpeed();
        Volvo.brake(0.1);
        double newSpeed = Volvo.getCurrentSpeed();
        boolean greaterThen = newSpeed < oldSpeed;
        Assertions.assertTrue(greaterThen, "The new speed should be less then the old speed");
    }


    @Test
    public void turnRight() {
        double oldDirection = Volvo.getDirection();
        Volvo.turnRight();
        double exp = (oldDirection + 1)%4;
        Assertions.assertEquals(exp, Volvo.getDirection(), "The new direction after turning right");
    }

    @Test
    public void turnLeft() {
        double oldDirection = Volvo.getDirection();
        Volvo.turnLeft();
        double exp = ((oldDirection - 1)%4 +4) % 4; // kan inte ha modulo på ett negativt tal
        Assertions.assertEquals(exp, Volvo.getDirection(), "The new direction after turning left");
    }

    @Test
    public void move0() {
        List<Double> beforePos = new ArrayList<>(Volvo.getPosition());
        Volvo.gas(0.5);
        Volvo.move();
        Assertions.assertNotEquals(beforePos, Volvo.getPosition(), "The position should have changed if current speed > 0");
    }

    @Test
    public void move1() {
        List<Double> beforePos = new ArrayList<>(Volvo.getPosition());
        Volvo.gas(0.5);
        Volvo.turnRight();
        Volvo.move();
        Assertions.assertNotEquals(beforePos, Volvo.getPosition(), "The position should have changed if current speed > 0");
    }

    @Test
    public void move2() {
        List<Double> beforePos = new ArrayList<>(Volvo.getPosition());
        Volvo.gas(0.5);
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.move();
        Assertions.assertNotEquals(beforePos, Volvo.getPosition(), "The position should have changed if current speed > 0");
    }

    @Test
    public void move3() {
        List<Double> beforePos = new ArrayList<>(Volvo.getPosition());
        Volvo.gas(0.5);
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.turnRight();
        Volvo.move();
        Assertions.assertNotEquals(beforePos, Volvo.getPosition(), "The position should have changed if current speed > 0");
    }
}