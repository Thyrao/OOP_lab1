import java.awt.*;

public class Volvo240 implements Vehicle, Movable{
    private final Car car;
    public Volvo240(){
        car = new Car(new VolvoEngine(), 4, 100, Color.black, "Volvo240");
    }

    @Override
    public int getNrDoors() {
        return car.getNrDoors();
    }

    @Override
    public double getEnginePower() {
        return car.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return car.color;
    }

    @Override
    public void setColor(Color clr) {
        car.setColor(clr);
    }

    @Override
    public void startEngine() {
        car.startEngine();
    }

    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    @Override
    public void gas(double amount) {
        car.gas(amount);
    }

    @Override
    public void brake(double amount) {
        car.brake(amount);
    }

    @Override
    public double getDirection() {
        return car.getDirection();
    }

    @Override
    public void turnRight() {
        car.turnRight();
    }

    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    @Override
    public double[] getPosition() {
        return car.getPosition();
    }

    @Override
    public void move() {
        car.move();
    }


    public void incrementSpeed(double amount) {
        car.incrementSpeed(amount);
    }

    public void decrementSpeed(double amount) {
         car.decrementSpeed(amount);
    }


    public double speedFactor() {
        return car.speedFactor();
    }
}

class VolvoEngine implements Engine{
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