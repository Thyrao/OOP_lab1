package Lorry;
import Interface.Vehicle;
import Interface.Movable;
import Interface.ITruck;
import Interface.ICar;
import Base.Truck;
import Lorry.LorryTruckbed;


import java.awt.*;
import java.util.ArrayList;


public class Lorry implements Movable, Vehicle, ITruck {
    private final Truck truck;
    private final LorryTruckbed lorryTruckbed;

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
            for (ICar c : getLoadedCars()){
                c.updatePosition(getPosition().get(0), getPosition().get(1));
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

    public ICar unload(){
        return lorryTruckbed.unload();
    }
}
