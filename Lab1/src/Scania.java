import java.awt.*;

 public class Scania implements Movable,Vehicle {
    private final Truck truck;
    protected ScaniaTruckbed scaniaTruckbed;

    public Scania() {
        truck = new Truck(new ScaniaEngine(),  2, 175, Color.pink, "Scania");
        scaniaTruckbed = new ScaniaTruckbed();
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
        if (getAngle() == 0){
            truck.gas(amount);
        }
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

     public void lower(double amount){
        scaniaTruckbed.lower(amount, getCurrentSpeed());

     }
     public void raise(double amount){
        scaniaTruckbed.raise(amount, getCurrentSpeed());
     }

     public double getAngle(){
        return scaniaTruckbed.getAngle();
     }
 }

class ScaniaEngine implements Engine{
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

class ScaniaTruckbed{
    protected double angle;
    public ScaniaTruckbed(){
        this.angle = 0;
    }

    public void lower(double amount, double currentSpeed) {
        if (currentSpeed == 0) {
            angle -= amount;
            if  (angle < 0)
               angle = 0;
        }
    }

    public void raise(double amount, double currentSpeed) {
        if (currentSpeed == 0){
            angle += amount;
            if (angle > 70)
                angle = 70;
        }
    }

    public double getAngle() {
        return angle;
    }
}