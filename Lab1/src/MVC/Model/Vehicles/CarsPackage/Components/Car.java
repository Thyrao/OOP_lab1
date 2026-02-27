package MVC.Model.Vehicles.CarsPackage.Components;

import MVC.Model.LoadedState;
import MVC.Model.State;
import MVC.Model.UnloadedState;
import MVC.Model.Vehicles.Movable;
import MVC.Model.Vehicles.Vehicle;
import MVC.Model.Vehicles.Engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Car implements Movable, ICar, Vehicle{
    protected Engine engine;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double posX;
    protected double posY;
    protected double direction;
    protected int carSize;
    protected List<Double> position;
    protected State state;

    public Car(Engine engine, int nrDoors, int enginePower, Color color, String modelName, int carSize){
        this.engine = engine;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.position = new ArrayList<>(2);
        position.add(0, 0.0);
        position.add(1, 0.0);
        posX = 0.0;
        posY = 0.0;
        this.direction = 0;
        this.carSize = carSize;
        this.state = new UnloadedState(this, engine);
        stopEngine();
    }

    // funktioner
    public int getNrDoors() {
        return nrDoors;}

    public void changeState(State state){
        this.state = state;
    }

    public Engine getEngine(){
        return engine;
    }

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
        state.startEngine();}

    public void stopEngine(){
        currentSpeed = 0.0;}

    public void gas(double amount){
        state.gas(amount);
    }

    public void brake(double amount){
        state.brake(amount);
    }

    public double getDirection(){
        return direction;
    }

    public void updateDirection(double dir){
        direction = dir;
    }

    public void turnRight(){
        state.turnRight();
    }

    public void turnLeft(){
        state.turnLeft();
    }

    public void updatePosition(double x, double y){
        posX = x;
        posY = y;

    }
     public List<Double> getPosition() {
        position.set(0, posX);
        position.set(1, posY);
        return new ArrayList<>(position);
     }

     public void move(){
         state.move();
     }
}

