import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

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
    public void incrementSpeed() {
        double inc = Saab.getCurrentSpeed() + Saab.speedFactor() * 0.5;
        Saab.incrementSpeed(0.5);
        Assertions.assertEquals(inc, Saab.getCurrentSpeed(), "Expected increased speed");
    }

    @Test
    public void decrementSpeed() {
        double dec = Saab.getCurrentSpeed() - Saab.speedFactor() * 0.5;
        Saab.decrementSpeed(0.5);
        Assertions.assertEquals(dec, Saab.getCurrentSpeed(), "The speed should've decreased");
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

    /*@Test
    public void getPosition() {
        double posX = Saab.getPosition()[0];
        double posY = Saab.getPosition()[1];
        Saab.move()
        Assertions.assertEquals(0.0, Saab.getPosition()[0]);
    }*/

    @Test
    public void move0() {
        double[] beforePos = Saab.getPosition();
        Saab.gas(0.5);
        Saab.move();
        double[] afterPos = Saab.getPosition();
        Assertions.assertNotEquals(beforePos, afterPos, "The position should have changed if current speed > 0");
    }

    @Test
    public void move1() {
        double[] beforePos = Saab.getPosition();
        Saab.gas(0.5);
        Saab.turnRight();
        Saab.move();
        double[] afterPos = Saab.getPosition();
        Assertions.assertNotEquals(beforePos, afterPos, "The position should have changed if current speed > 0");
    }

    @Test
    public void move2() {
        double[] beforePos = Saab.getPosition();
        Saab.gas(0.5);
        Saab.turnRight();
        Saab.turnRight();
        Saab.move();
        double[] afterPos = Saab.getPosition();
        Assertions.assertNotEquals(beforePos, afterPos, "The position should have changed if current speed > 0");
    }

    @Test
    public void move3() {
        double[] beforePos = Saab.getPosition();
        Saab.gas(0.5);
        Saab.turnRight();
        Saab.turnRight();
        Saab.turnRight();
        Saab.move();
        double[] afterPos = Saab.getPosition();
        Assertions.assertNotEquals(beforePos, afterPos, "The position should have changed if current speed > 0");
    }
}