package MVC.Vehicles.CarsPackage.Engines;

import MVC.Vehicles.Engine;

public class VolvoEngine implements Engine {
    private final static double trimFactor = 1.25;

    @Override
    public double speedFactor(double enginePower){
        return enginePower * 0.01 * trimFactor;
    }

    @Override
    public double incrementSpeed(double currentSpeedx, double speedFactor, double amount, double enginePower){
        return Math.min(currentSpeedx + speedFactor * amount, enginePower);
    }

    @Override
    public double decrementSpeed(double currentSpeedx, double speedFactor, double amount, double enginePower){
        return Math.max(currentSpeedx - speedFactor * amount,0);
    }

}
