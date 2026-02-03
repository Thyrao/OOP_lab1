import java.awt.*;

public class Scania extends Car implements Truckbed{
    protected double angle;

    public Scania() {
        super(new ScaniaEngine(), 2,  175, Color.pink, "Scania");
        this.angle = 0;
    }

    @Override
    public void lower(double amount) {
        if (getCurrentSpeed() == 0) {
            angle -= amount;
            if  (angle < 0)
                angle = 0;
        }
        //else throw new RuntimeException("The Truck must first stand still ");
    }

    @Override
    public void raise(double amount) {
        if (getCurrentSpeed() == 0){
            angle += amount;
            if (angle > 70)
                angle = 70;
        }
        //else throw new RuntimeException("The Truck must first stand still ");
    }

    @Override
    public double getAngle() {
        return angle;
    }
}

class ScaniaEngine implements Engine{
    
    @Override
    public double incrementSpeed(double currentSpeedx, double speedFactor, double amount, double enginePower) {
        //här vill vi ha angle
        return currentSpeedx + speedFactor * amount;
    }

    @Override
    public double decrementSpeed(double currentSpeedx, double speedFactor, double amount, double enginePower) {
        return currentSpeedx - speedFactor * amount;
    }

    @Override
    public double speedFactor(double enginePower) {
        return enginePower * 0.01;
    }
}