package MVC.Model;

import MVC.Model.Vehicles.CarsPackage.Cars.Saab95;
import MVC.Model.Vehicles.CarsPackage.Cars.Volvo240;
import MVC.Model.Vehicles.TrucksPackage.Trucks.Scania;
import MVC.Model.Vehicles.Vehicle;


public class VehicleFactory {
    public static Pair<Vehicle, String> createVolvo() {
        Volvo240 volvo = new Volvo240();
        volvo.updatePosition(0,100);
        return new Pair<>(volvo, "Volvo240.jpg");
    }

    public static Pair<Vehicle, String> createSaab() {
        Saab95 saab = new Saab95();
        saab.updatePosition(0,200);
        return new Pair<>(saab, "Saab95.jpg");
    }

    public static Pair<Vehicle, String> createScania(){
        return new Pair<>(new Scania(), "Scania.jpg");
    }
}
