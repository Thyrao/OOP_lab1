import java.awt.*;
import java.util.ArrayList;

class Scania implements Movable,Vehicle, ITruck {
    private final Truck truck;
    private final ScaniaTruckbed scaniaTruckbed;

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
     public ArrayList<Double> getPosition() {
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
