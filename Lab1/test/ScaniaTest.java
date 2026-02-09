import Scania.Scania;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ScaniaTest{
    Scania scania = new Scania();

    @Test
    public void lowerOnSpeed() {
        double old_angle = scania.getAngle();
        scania.gas(0.5);
        scania.lower(35);
        Assertions.assertEquals(old_angle, scania.getAngle());
    }


    @Test
    public void raiseOnSpeed() {
        double old_angle = scania.getAngle();
        scania.gas(0.5);
        scania.raise(10);
        Assertions.assertEquals(old_angle, scania.getAngle());
    }

    @Test
    public void lowerOnStill() {
        scania.stopEngine();
        scania.raise(70);
        scania.lower(10);
        Assertions.assertEquals(60, scania.getAngle());
    }

    @Test
    public void raiseOnStill() {
        scania.stopEngine();
        scania.lower(70);
        double old_angle = scania.getAngle();
        scania.raise(10);
        Assertions.assertEquals(old_angle, (scania.getAngle() - 10));
    }

    @Test
    public void lower_span(){
        scania.stopEngine();
        scania.lower(100);
        Assertions.assertEquals(0, scania.getAngle());
    }


    @Test
    public void higher_span() {
        scania.stopEngine();
        scania.raise(100);
        Assertions.assertEquals(70, scania.getAngle());
    }

    @Test
    public void incrementSpeedRaise() {
        scania.stopEngine();
        double old_speed = scania.getCurrentSpeed();
        scania.raise(40);
        scania.gas(0.5);
        Assertions.assertEquals(old_speed,scania.getCurrentSpeed());
    }

    @Test
    public void incrementSpeedOn0() {
        scania.lower(70);
        double old_speed = scania.getCurrentSpeed();
        scania.gas(0.5);
        Assertions.assertTrue(scania.getCurrentSpeed() > old_speed);
    }
}