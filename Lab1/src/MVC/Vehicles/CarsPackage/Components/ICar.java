package MVC.Vehicles.CarsPackage.Components;

import MVC.Vehicles.Vehicle;

public interface ICar extends Vehicle {
    void updatePosition(double x, double y);
    int getCarSize();

}
