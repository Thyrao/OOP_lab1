package MVC.Model.Vehicles.CarsPackage.Components;

import MVC.Model.State;
import MVC.Model.Vehicles.Engine;
import MVC.Model.Vehicles.Vehicle;

public interface ICar extends Vehicle {
    Engine getEngine();
    int getCarSize();
    void changeState(State state);

}
