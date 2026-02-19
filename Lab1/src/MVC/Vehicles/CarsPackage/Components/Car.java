package MVC.Vehicles.CarsPackage.Components;

import MVC.Vehicles.Movable;
import MVC.Vehicles.Vehicle;
import MVC.Vehicles.Engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

 public class Car implements Movable, ICar, Vehicle{
    // variabler
    public Engine engine;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double posX;
    protected double posY;
    protected List<Double> pos;
    protected double direction;
    protected int carSize;

    public Car(Engine engine, int nrDoors, double enginePower, Color color, String modelName, int carSize){
        this.engine = engine;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.posX = 0.0;
        this.posY = 0.0;
        this.direction = 0;
        this.carSize = carSize;
        this.pos = new ArrayList<>();
        pos.add(0, 0.0);
        pos.add(1, 0.0);
        stopEngine();
    }

    // funktioner
    public int getNrDoors() {
        return nrDoors;}

    public int getCarSize(){
        return carSize;
    }

    public double getEnginePower() {
        return enginePower;}

    public double getCurrentSpeed() {
        return currentSpeed;}

    public Color getColor() {
        return color;}

    public void setCurrentSpeed(double amount){
        currentSpeed = amount;
    }

    public void setColor(Color clr) {
        color = clr;}

    public void startEngine(){
        currentSpeed = 0.1;}

    public void stopEngine(){
        currentSpeed = 0;}

    public void gas(double amount){
        double oldSpeed = getCurrentSpeed();
        if(amount >= 0 && amount <=1){
            double newSpeed = engine.incrementSpeed(getCurrentSpeed(), engine.speedFactor(getEnginePower()), amount, getEnginePower());
            if(newSpeed < oldSpeed){
                currentSpeed = oldSpeed;
            }
            else if (newSpeed > getEnginePower()){
                currentSpeed = getEnginePower();
            }
            else currentSpeed = newSpeed;
        }
    }

    public void brake(double amount){
        double oldSpeed = getCurrentSpeed();
        if(amount >= 0 && amount <=1){
            double newSpeed = engine.decrementSpeed(getCurrentSpeed(), engine.speedFactor(getEnginePower()), amount, getEnginePower());
            if (newSpeed > oldSpeed){
                currentSpeed = oldSpeed;
            }
            else if (newSpeed < 0){
                currentSpeed = 0;
            }
            else currentSpeed = newSpeed;
        }
    }

    public double getDirection(){
        return direction;
    }

    public void turnRight(){
        direction = (getDirection() + 1)%4;
    }

    public void turnLeft(){
        direction = ((getDirection() - 1)%4 +4) % 4; // kan inte ha modulo på ett negativt tal
    }

    public void updatePosition(double x, double y){
        posX = x;
        posY = y;
    }

    public List<Double> getPosition(){
        pos.set(0, posX);
        pos.set(1, posY);
        return pos;
    }

    public void move(){
        double dir = getDirection();
        List<Double> pos = getPosition();

        if (dir == 0){
            posY = pos.get(1) + getCurrentSpeed();
        }
        else if (dir == 1){
            posX = pos.get(0) + getCurrentSpeed();
        }
        else if (dir == 2){
            posY = pos.get(1) - getCurrentSpeed();
        }
        else {
            posX = pos.get(0) - getCurrentSpeed();
        }
    }

}

