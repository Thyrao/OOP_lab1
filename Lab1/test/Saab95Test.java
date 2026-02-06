import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;
import java.util.ArrayList;

public class Saab95Test {
    Saab95 Saab = new Saab95();

    @Test
    public void getNrDoors() {
        Assertions.assertEquals(2, Saab.getNrDoors(), "Number of doors should be 2");
    }

    @Test
    public void getEnginePower() {Assertions.assertEquals(125, Saab.getEnginePower(), "Engine power should be 125");}

    @Test
    public void get_set_Color() {
        Saab.setColor(Color.red);
        Assertions.assertEquals(Color.red, Saab.getColor(), "Every cool car is Red...");
    }

    @Test
    public void startEngine() {
        Saab.startEngine();
        Assertions.assertEquals(0.1,Saab.getCurrentSpeed(), "When engine has started it should be 0.1");
    }

    @Test
    public void stopEngine() {
        Saab.stopEngine();
        Assertions.assertEquals(0,Saab.getCurrentSpeed(), "When engine is stopped it should be 0");
    }

    @Test
    public void speedFactor() {
        Saab.setTurboOn();
        Assertions.assertEquals(1.625, Saab.speedFactor(), "Speed factor if turbo is on");
        Saab.setTurboOff();
        Assertions.assertEquals(1.25, Saab.speedFactor(), "Speed factor if turbo is off");
    }

    @Test
    public void gas() {
        double oldSpeed = Saab.getCurrentSpeed();
        Saab.gas(0.5);
        double newSpeed = Saab.getCurrentSpeed();
        boolean greaterThen = newSpeed > oldSpeed;
        Assertions.assertTrue(greaterThen, "The new speed should be bigger than the old speed");
    }

    @Test
    public void gas_on_max() {
        while (Saab.getCurrentSpeed() < Saab.getEnginePower()){
            Saab.gas(1);
        }
        Saab.gas(0.5);
        double newSpeed = Saab.getCurrentSpeed();
        Assertions.assertEquals(newSpeed, Saab.getEnginePower());

    }

    @Test
    public void brakeOn0() {
        Saab.gas(0.3);
        Saab.stopEngine();
        Saab.brake(0.1);
        Assertions.assertEquals(0, Saab.getCurrentSpeed(), "Break with no speed");
    }

    @Test
    public void brake() {
        Saab.gas(0.3);
        double oldSpeed = Saab.getCurrentSpeed();
        Saab.brake(0.1);
        double newSpeed = Saab.getCurrentSpeed();
        boolean greaterThen = newSpeed < oldSpeed;
        Assertions.assertTrue(greaterThen, "The new speed should be less then the old speed");
    }

    @Test
    public void turnRight() {
        double oldDirection = Saab.getDirection();
        Saab.turnRight();
        double exp = (oldDirection + 1)%4;
        Assertions.assertEquals(exp, Saab.getDirection(), "The direction didn't update correctly when turning right");
    }

    @Test
    public void turnLeft() {
        double oldDirection = Saab.getDirection();
        Saab.turnLeft();
        double exp = ((oldDirection - 1)%4 +4) % 4;
        Assertions.assertEquals(exp, Saab.getDirection(), "The direction didn't update correctly when turning left");
    }

    @Test
    public void move0() {
        ArrayList<Double> beforePos = Saab.getPosition();
        Saab.gas(0.5);
        Saab.move();
        ArrayList<Double> afterPos = Saab.getPosition();
        Assertions.assertNotEquals(beforePos, afterPos, "The position should have changed if current speed > 0");
    }

    @Test
    public void move1() {
        ArrayList<Double> beforePos = Saab.getPosition();
        Saab.gas(0.5);
        Saab.turnRight();
        Saab.move();
        ArrayList<Double> afterPos = Saab.getPosition();
        Assertions.assertNotEquals(beforePos, afterPos, "The position should have changed if current speed > 0");
    }

    @Test
    public void move2() {
        ArrayList<Double> beforePos = Saab.getPosition();
        Saab.gas(0.5);
        Saab.turnRight();
        Saab.turnRight();
        Saab.move();
        ArrayList<Double> afterPos = Saab.getPosition();
        Assertions.assertNotEquals(beforePos, afterPos, "The position should have changed if current speed > 0");
    }

    @Test
    public void move3() {
        ArrayList<Double> beforePos = Saab.getPosition();
        Saab.gas(0.5);
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Saab.move();
        ArrayList<Double> afterPos = Saab.getPosition();
        Assertions.assertNotEquals(beforePos, afterPos, "The position should have changed if current speed > 0");
    }
}