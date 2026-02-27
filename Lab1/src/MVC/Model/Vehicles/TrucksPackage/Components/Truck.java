package MVC.Model.Vehicles.TrucksPackage.Components;

import MVC.Model.State;
import MVC.Model.UnloadedState;
import MVC.Model.Vehicles.Movable;
import MVC.Model.Vehicles.Vehicle;
import MVC.Model.Vehicles.Engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Truck implements Movable, Vehicle, ITruck {
    protected Engine engine;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double direction;
    protected List<Double> position;
    protected double posX;
    protected double posY;
    State state;


    public Truck(Engine engine, int nrDoors, double enginePower, Color color, String modelName){
        this.engine = engine;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.direction = 0;
        this.position = new ArrayList<>();
        position.add(0, 0.0);
        position.add(1, 0.0);
        posX = 0.0;
        posY = 0.0;
        this.state = new UnloadedState(this, engine);
        stopEngine();
    }

    public void changeState(State state){
        this.state = state;
    }

    public Engine getEngine(){
        return engine;
    }

    public int getNrDoors() {
        return nrDoors;}

    public double getEnginePower() {
        return enginePower;}

    public double getCurrentSpeed() {
        return currentSpeed;}

    public Color getColor() {
        return color;}

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

    public void updateDirection(double dir){
        direction = dir;
    }
    public void turnRight(){
        direction = (getDirection() + 1)%4;
    }

    public void turnLeft(){
        direction = ((getDirection() - 1)%4 +4) % 4; // kan inte ha modulo på ett negativt tal
    }

    public List<Double> getPosition() {
        position.set(0, posX);
        position.set(1, posY);
        return new ArrayList<>(position);
    }

    public void move(){
        double dir = getDirection();

        if (dir == 0){
            posY +=  getCurrentSpeed();
        }
        else if (dir == 1){
            posX -=  getCurrentSpeed();
        }
        else if (dir == 2){
            posY -= getCurrentSpeed();
        }
        else {
            posX += getCurrentSpeed();
        }
    }

    public void setCurrentSpeed(double amount){
        currentSpeed = amount;
    }

    @Override
    public void updatePosition(double x, double y) {
        posX = x;
        posY = y;
    }
}