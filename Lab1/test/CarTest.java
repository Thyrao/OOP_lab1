import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

public class CarTest {
    Saab95 Saab = new Saab95();

    @Test
    public void getNrDoors() {
        Assertions.assertEquals(2, Saab.getNrDoors(), "Number of doors should be 2");
    }

    @Test
    public void getEnginePower() {
        Assertions.assertEquals(125, Saab.getEnginePower(), "Engine power should be 125");
    }

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
        if(Saab.turboOn){
            Assertions.assertEquals(1.625, Saab.speedFactor(), "Speed factor if turbo is on");
        } else {
            Assertions.assertEquals(1.25, Saab.speedFactor(), "Speed factor if turbo is off");
        }
    }

    @Test
    public void incrementSpeed() {
        double inc = Saab.getCurrentSpeed() + Saab.speedFactor() * 0.5;
        Saab.incrementSpeed(0.5);
        Assertions.assertEquals(inc, Saab.getCurrentSpeed());
    }

    @Test
    public void decrementSpeed() {
        double dec = Saab.getCurrentSpeed() - Saab.speedFactor() * 0.5;
        Saab.decrementSpeed(0.5);
        Assertions.assertEquals(dec, Saab.getCurrentSpeed());
    }

    @Test
    public void gas() {
        double oldSpeed = Saab.getCurrentSpeed();
        Saab.gas(0.5);
        double newSpeed = Saab.getCurrentSpeed();
        boolean greaterThen = newSpeed > oldSpeed;
        Assertions.assertTrue(greaterThen);
    }

    @Test
    public void brake() {
        double oldSpeed = Saab.getCurrentSpeed();
        Saab.brake(0.5);
        double newSpeed = Saab.getCurrentSpeed();
        boolean greaterThen = newSpeed < oldSpeed;
        Assertions.assertTrue(greaterThen);
    }


    @Test
    public void turnRight() {
        double oldDirection = Saab.getDirection();
        Saab.turnRight();
        double exp = (oldDirection + 1)%4;
        Assertions.assertEquals(exp, Saab.getDirection());
    }

    @Test
    public void turnLeft() {
        double oldDirection = Saab.getDirection();
        Saab.turnRight();
        double exp = (oldDirection - 1)%4;
        Assertions.assertEquals(exp, Saab.getDirection());
    }

    /*@Test
    public void getPosition() {
        double posX = Saab.getPosition()[0];
        double posY = Saab.getPosition()[1];
        Saab.move()
        Assertions.assertEquals(0.0, Saab.getPosition()[0]);
    }*/

    @Test
    public void move() {
        double[] pos = Saab.getPosition();
        double b4x = pos[0];
        double b4y = pos[1];
        Saab.move();
        double[] after_pos = Saab.getPosition();
        double afx = after_pos[0];
        double afy = after_pos[1];
        Assertions.assertNotEquals(b4x, afx);
        Assertions.assertNotEquals(b4y, afy);
    }
}