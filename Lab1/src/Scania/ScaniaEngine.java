package Scania;
import Interface.Engine;

public class ScaniaEngine implements Engine {
    @Override
    public double incrementSpeed(double currentSpeedx, double speedFactor, double amount, double enginePower) {
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
