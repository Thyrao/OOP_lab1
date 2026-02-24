import MVC.Controllers.CarController;
import MVC.Model.TimerListener;
import MVC.Model.NoneMoveableObjects.ServiceStation;
import MVC.Model.Vehicles.CarsPackage.Cars.Saab95;
import MVC.Model.Vehicles.CarsPackage.Cars.Volvo240;
import MVC.Model.Vehicles.TrucksPackage.Trucks.Scania;
import MVC.Model.Vehicles.Vehicle;

import javax.swing.*;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {
    // Instance of this class
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ServiceStation<Volvo240> volvoService = new ServiceStation<>(20);
    CarController cc = new CarController();
    final int delay = 50;
    Timer timer = new Timer(delay, new TimerListener());
    //CarView frame;

    // Start a new view and send a reference of self
    //frame = new CarView("CarSim 1.0", cc);

    // Start the timer
    timer.start();
}

