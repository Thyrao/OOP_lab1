import java.awt.*;

public class Lorry implements Movable,Vehicle {
    private final Truck truck;
    protected LorryTruckbed lorryTruckbed;

    protected double angle;

    public Lorry() {
        this.lorryTruckbed  = new LorryTruckbed();
        truck = new Truck(new LorryEngine(),   2, 200, Color.cyan, "Lorry");
        this.angle = 0;
    }



    @Override
    public int getNrDoors() {
        return truck.getNrDoors();
    }

    @Override
    public double getEnginePower() {
        return truck.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return truck.getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return truck.getColor();
    }

    @Override
    public void setColor(Color clr) {
        truck.setColor(clr);
    }

    @Override
    public void startEngine() {
        truck.startEngine();
    }

    @Override
    public void stopEngine() {
        truck.stopEngine();
    }

    @Override
    public void gas(double amount) {
        truck.gas(amount);
    }

    @Override
    public void brake(double amount) {
        truck.brake(amount);
    }

    @Override
    public double getDirection() {
        return truck.getDirection();
    }

    @Override
    public void turnRight() {
        truck.turnRight();
    }

    @Override
    public void turnLeft() {
        truck.turnLeft();
    }

    @Override
    public double[] getPosition() {
        return truck.getPosition();
    }

    @Override
    public void move() {
        truck.move();
    }

    public void raise(){
        lorryTruckbed.raise(getCurrentSpeed());
    }

    public void lower(){
        lorryTruckbed.lower(getCurrentSpeed());
    }

    public void getAngle(){
        lorryTruckbed.getAngle();
    }

}

class LorryEngine implements Engine{
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

class LorryTruckbed{
    protected double angle;

    public LorryTruckbed(){
        this.angle = angle;
    }

    public void lower(double currentSpeed) {
        if (currentSpeed == 0) {
            angle = 70;
        }
    }

    public void raise(double currentSpeed) {
        if (currentSpeed == 0){
            angle = 0;
        }
    }

    public double getAngle() {
        return angle;
    }
}
