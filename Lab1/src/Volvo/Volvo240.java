package Volvo;
import Base.Car;
import Interface.ICar;
import Interface.Movable;
import Interface.Vehicle;

import java.awt.*;
import java.util.List;

public class Volvo240 implements Vehicle, Movable, ICar {
    private final Car car;
    public Volvo240(){
        car = new Car(new VolvoEngine(), 4, 100, Color.black, "Volvo240", 2);
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
    public List<Double> getPosition() {
        return car.getPosition();
    }

    public  void updatePosition(double x, double y){
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