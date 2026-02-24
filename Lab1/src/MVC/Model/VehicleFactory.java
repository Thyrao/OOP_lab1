package MVC.Model;

import MVC.Model.Vehicles.CarsPackage.Cars.Saab95;
import MVC.Model.Vehicles.CarsPackage.Cars.Volvo240;
import MVC.Model.Vehicles.TrucksPackage.Trucks.Scania;
import MVC.Model.Vehicles.Vehicle;
import MVC.Views.DrawPanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class VehicleFactory {

    public static Vehicle createVolvo() {

        return new Volvo240();
    }

    public static Vehicle createSaab() {

        return new Saab95();
    }

    public static Vehicle createScania(){
        return new Scania();
    }
}
