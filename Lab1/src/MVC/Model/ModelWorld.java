package MVC.Model;

import MVC.Model.NoneMoveableObjects.ServiceStation;
import MVC.Model.Vehicles.CarsPackage.Cars.Saab95;
import MVC.Model.Vehicles.CarsPackage.Cars.Volvo240;
import MVC.Model.Vehicles.TrucksPackage.Trucks.Scania;
import MVC.Model.Vehicles.Vehicle;
import MVC.Views.DrawPanel;
import MVC.Views.Observer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class ModelWorld {
    HashMap<Vehicle, BufferedImage> vehicles = new HashMap<>();
    ServiceStation<Volvo240> volvoWorkshop;

    public ModelWorld(){
        addVolvo();
        addSaab();
        addScania();
        ServiceStation<Volvo240> volvoWorkshop = new ServiceStation<>(20);
    }

    public void addVolvo(){
        Vehicle volvo  = VehicleFactory.createVolvo();
        BufferedImage volvoImage = null;
        try {
            volvoImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        vehicles.put(volvo, volvoImage);
    }

    public void addSaab(){
        Vehicle saab  = VehicleFactory.createSaab();
        BufferedImage saabImage = null;
        try {
            saabImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        vehicles.put(saab, saabImage);
    }

    public void addScania(){
        Vehicle scania  = VehicleFactory.createScania();
        BufferedImage scaniaImage = null;
        try {
            scaniaImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        vehicles.put(scania, scaniaImage);
    }

    public HashMap<Vehicle,BufferedImage> getVehicles(){
        return vehicles;
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
                volvoWorkshop.handInCar((Volvo240) vehicle); // ska verkligen en klocka ha en volvoService
                vehicles.remove(vehicle); // eftersom vi nu inte har någon CarView utan endast använder den som en observer kommer inte detta fungera alls
                ((Volvo240) vehicle).updatePosition(0,0);
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
