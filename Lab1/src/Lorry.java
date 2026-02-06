import java.awt.*;
import java.util.ArrayList;

public class Lorry implements Movable,Vehicle {
    private final Truck truck;
    protected LorryTruckbed lorryTruckbed;

    public Lorry() {
        truck = new Truck(new LorryEngine(),2, 200, Color.cyan, "Lorry");
        this.lorryTruckbed  = new LorryTruckbed();
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
        if(getAngle() == 0){
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
        if (!getLoadedCars().isEmpty()){
            for (int i=0; i < getLoadedCars().size(); i++){
                getLoadedCars().get(i).updatePosition(getPosition().get(0), getPosition().get(1));
            }
        }
    }

    public void raise(){
        lorryTruckbed.raise(getCurrentSpeed());
    }

    public void lower(){
        lorryTruckbed.lower(getCurrentSpeed());
    }

    public double getAngle(){
        return lorryTruckbed.getAngle();
    }

    public ArrayList<ICar> getLoadedCars(){
        return lorryTruckbed.getLoadedCars();
    }

    public void load(ICar car){
        lorryTruckbed.load(car, getPosition());
    }

    public void unload(){
        lorryTruckbed.unload();
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
    private ArrayList<ICar> loadedCars;


    public LorryTruckbed(){
        this.angle = 0;
        this.loadedCars = new ArrayList<>(5);
    }

    public void lower(double currentSpeed) {
        if (currentSpeed == 0) {
            angle = 0;
        }
    }

    public void raise(double currentSpeed) {
        if (currentSpeed == 0){
            angle = 70;
        }
    }

    public double getAngle() {
        return angle;
    }

    public void load(ICar car, ArrayList<Double> position){
        if ((Math.abs(car.getPosition().get(0) - position.get(0)) < 1) && (Math.abs(car.getPosition().get(1) - position.get(1)) < 1)){
            if (angle == 70)
                if (car.getCarSize() < 5)
                    loadedCars.add(car); // vad händer när listan är full och vi försöker lasta ne ny bil?
        }
    }

    public void unload(){
        ICar unloadedCar;
        if (angle == 70) {
            if (!getLoadedCars().isEmpty()) {
                unloadedCar = getLoadedCars().getLast();
                getLoadedCars().removeLast();
                unloadedCar.updatePosition(unloadedCar.getPosition().get(0)+1, unloadedCar.getPosition().get(1)+1);
            }
        }
    }

    public ArrayList<ICar> getLoadedCars() {
        return loadedCars;
    }

}
