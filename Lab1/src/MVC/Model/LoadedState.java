package MVC.Model;

import MVC.Model.Vehicles.Engine;
import MVC.Model.Vehicles.Vehicle;

public class LoadedState implements State{
    Vehicle vehicle;

    public LoadedState(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void turnRight(){
    };
    public void turnLeft(){
    };
    public void move(){
    };
    public void gas(double amount) {
        //vehicle.gas(0.0);
    }
    public void brake(double amount) {
    }
    public void startEngine() {
    }
}
