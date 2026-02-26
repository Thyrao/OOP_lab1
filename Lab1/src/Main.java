import MVC.Controllers.CarController;
import MVC.Model.TimerListener;
import MVC.Model.NoneMoveableObjects.ServiceStation;
import MVC.Model.Vehicles.CarsPackage.Cars.Saab95;
import MVC.Model.Vehicles.CarsPackage.Cars.Volvo240;
import MVC.Model.Vehicles.TrucksPackage.Trucks.Scania;
import MVC.Model.Vehicles.Vehicle;

import javax.swing.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {
    final int delay = 50;
    Timer timer = new Timer(delay, new TimerListener());
    timer.start();
}

