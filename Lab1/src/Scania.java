import java.awt.*;

 public class Scania implements Movable,Vehicle {
    private final Truck truck;
    protected double angle;

    public Scania() {
        truck = new Truck(new ScaniaEngine(), 2,  175, Color.pink, "Scania");
        this.angle = 0;
    }

    public void lower(double amount) {
        truck.lower(amount);
        //else throw new RuntimeException("The Truck must first stand still ");
    }

    public void raise(double amount) {
        truck.raise(amount);
        }
        //else throw new RuntimeException("The Truck must first stand still ");


    public double getAngle() {
        return truck.getAngle();
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


     public void incrementSpeed(double amount) {
         truck.incrementSpeed(amount);
     }


     public void decrementSpeed(double amount) {
          truck.decrementSpeed(amount);
     }


     public double speedFactor() {
         return truck.speedFactor();
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