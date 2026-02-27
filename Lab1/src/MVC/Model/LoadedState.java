package MVC.Model;

import MVC.Model.Vehicles.Engine;
import MVC.Model.Vehicles.Vehicle;

public class LoadedState implements State{
    Vehicle vehicle;

    public LoadedState(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void turnRight(){
        //vehicle.updateDirection(vehicle.getDirection());
    };
    public void turnLeft(){
        //vehicle.updateDirection((vehicle.getDirection()));
    };
    public void move(){
        //vehicle.updatePosition(vehicle.getPosition().getFirst(), vehicle.getPosition().getLast());
    };
    public void gas(double amount) {
        //vehicle.gas(0.0);
    }
    public void brake(double amount) {
        //vehicle.brake(0.0);
    }
    public void startEngine() {
    }
}
