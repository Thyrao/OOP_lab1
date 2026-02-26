package MVC.Model;

import MVC.Model.NoneMoveableObjects.ServiceStation;
import MVC.Model.Vehicles.CarsPackage.Cars.Saab95;
import MVC.Model.Vehicles.CarsPackage.Cars.Volvo240;
import MVC.Model.Vehicles.TrucksPackage.Trucks.Scania;
import MVC.Model.Vehicles.Vehicle;

import java.util.HashMap;


public class ModelWorld {
    private HashMap<Vehicle, String> vehicles = new HashMap<>();
    ServiceStation<Volvo240> volvoWorkshop;

    public ModelWorld(){
        addVolvo();
        addSaab();
        addScania();
        volvoWorkshop = new ServiceStation<>(20);
    }

    public void addVolvo(){
        Pair<Vehicle, String> volvo  = VehicleFactory.createVolvo();
        vehicles.put(volvo.getFirst(), volvo.getLast());
    }

    public void addSaab(){
        Pair<Vehicle, String> saab  = VehicleFactory.createSaab();
        vehicles.put(saab.getFirst(), saab.getLast());
    }

    public void addScania(){
        Pair<Vehicle, String> scania  = VehicleFactory.createScania();
        vehicles.put(scania.getFirst(), scania.getLast());
    }

    public HashMap<Vehicle,String> getVehicles(){
        return new HashMap<>(vehicles);
    }

    public void bounds(Vehicle vehicle, int x, int y) { // Ska detta vara en egen klass ist?
        double g;
        if (x > 700 || x < 0) {
            g = vehicle.getCurrentSpeed();
            vehicle.stopEngine();
            vehicle.turnLeft();
            vehicle.turnLeft();
            vehicle.startEngine();
            vehicle.setCurrentSpeed(g);
        }

        if (y > 500 || y < 0) {
            g = vehicle.getCurrentSpeed();
            vehicle.stopEngine();
            vehicle.turnLeft();
            vehicle.turnLeft();
            vehicle.startEngine();
            vehicle.setCurrentSpeed(g);
        }
        if (vehicle instanceof Volvo240) {
            if ((x < 400 && x > 200) && (y < 398 && y > 240)){
                vehicle.stopEngine();
                volvoWorkshop.handInCar((Volvo240) vehicle);
                vehicles.remove(vehicle);
            }
        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles.keySet()) {
            vehicle.gas(gas);
        }
    }

    public void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles.keySet()){
            vehicle.brake(brake);
        }
    }

    public void turnLeft(){
        for (Vehicle vehicle : vehicles.keySet()){
            vehicle.turnLeft();
        }
    }

    public void turnRight(){
        for (Vehicle vehicle : vehicles.keySet()){
            vehicle.turnRight();
        }
    }

    public void setTurboOn(){
        for (Vehicle vehicle : vehicles.keySet()){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    public void setTurboOff(){
        for (Vehicle vehicle : vehicles.keySet()){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    public void lowerTruckbed(int amount){
        for (Vehicle vehicle : vehicles.keySet()){
            if (vehicle instanceof Scania){
                ((Scania) vehicle).lower(amount);
            }
        }
    }

    public void raiseTruckbed(int amount){
        for (Vehicle vehicle : vehicles.keySet()){
            if (vehicle instanceof Scania){
                ((Scania) vehicle).raise(amount);
            }
        }
    }

    public void turnAllCarsOff(){
        for (Vehicle vehicle : vehicles.keySet()){
            vehicle.stopEngine();
        }
    }

    public void turnAllCarsOn(){
        for (Vehicle vehicle : vehicles.keySet()){
            vehicle.startEngine();
        }
    }
}
