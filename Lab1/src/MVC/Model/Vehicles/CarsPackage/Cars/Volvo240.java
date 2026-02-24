package MVC.Model.Vehicles.CarsPackage.Cars;
import MVC.Model.Vehicles.CarsPackage.Components.Car;
import MVC.Model.Vehicles.CarsPackage.Engines.VolvoEngine;
import MVC.Model.Vehicles.CarsPackage.Components.ICar;
import MVC.Model.Vehicles.Movable;
import MVC.Model.Vehicles.Vehicle;

import java.awt.*;

public class Volvo240 implements Vehicle, Movable, ICar {
    private final Car car;

    public Volvo240(){
        car = new Car(new VolvoEngine(), 4, 100, Color.black, "Volvo240", 2);
        car.updatePosition(0,-200);
    }

    @Override
    public int getNrDoors() {
        return car.getNrDoors();
    }

    public int getCarSize(){
        return car.getCarSize();
    }

    @Override
    public double getEnginePower() {
        return car.getEnginePower();
    }

    @Override
    public void setCurrentSpeed(double amount) {
        car.setCurrentSpeed(amount);
    }

    @Override
    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return car.getColor();
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
    public Point getPosition() {
        return car.getPosition();
    }

    public  void updatePosition(int x, int y){
        car.updatePosition(x,y);
    }

    @Override
    public void move() {
        car.move();
    }

    public double speedFactor(){
        return car.engine.speedFactor(getEnginePower());
    }
}