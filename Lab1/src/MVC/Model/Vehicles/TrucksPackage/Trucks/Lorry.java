package MVC.Model.Vehicles.TrucksPackage.Trucks;
import MVC.Model.Vehicles.TrucksPackage.Components.LorryTruckbed;
import MVC.Model.Vehicles.TrucksPackage.Engines.LorryEngine;
import MVC.Model.Vehicles.Vehicle;
import MVC.Model.Vehicles.Movable;
import MVC.Model.Vehicles.TrucksPackage.Components.ITruck;
import MVC.Model.Vehicles.CarsPackage.Components.ICar;
import MVC.Model.Vehicles.TrucksPackage.Components.Truck;

import java.awt.*;
import java.util.List;


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
    public void setCurrentSpeed(double amount) {
        truck.setCurrentSpeed(amount);
    }

    @Override
    public void updatePosition(double x, double y) {
        truck.updatePosition(x, y);
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
        if(!getAngle()){
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
    public List<Double> getPosition() {
        return truck.getPosition();
    }

    @Override
    public void move() {
        truck.move();
        if (!getLoadedCars().isEmpty()){
            for (ICar c : getLoadedCars()){
                c.updatePosition(getPosition().getFirst(), getPosition().getLast());
            }
        }
    }

    public void raise(){
        lorryTruckbed.raise(getCurrentSpeed());
    }

    public void lower(){
        lorryTruckbed.lower(getCurrentSpeed());
    }

    public boolean getAngle(){
        return lorryTruckbed.getAngle();
    }

    public List<ICar> getLoadedCars(){
        return lorryTruckbed.getLoadedCars();
    }

    public void load(ICar car){
        lorryTruckbed.load(car, getPosition());

    }

    public ICar unload(){
        return lorryTruckbed.unload();
    }
}
