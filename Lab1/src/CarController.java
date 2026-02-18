import Base.ServiceStation;
import Interface.Vehicle;
import Saab.Saab95;
import Scania.Scania;
import Volvo.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());
    ServiceStation<Volvo240> volvoService = new ServiceStation<>(20);
    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) { 
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        double g;
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getPosition().getFirst());
                int y = (int) -Math.round(vehicle.getPosition().getLast()); // "-" för att koordinatsystemet är flippat
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
                        volvoService.handInCar((Volvo240) vehicle);
                        frame.drawPanel.volvoImage = null;
                        ((Volvo240) vehicle).updatePosition(0,0);
                    }
                }
                    frame.drawPanel.moveit(vehicle, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles){
            vehicle.brake(brake);
        }
    }

    void turnLeft(){
        for (Vehicle vehicle : vehicles){
            vehicle.turnLeft();
        }
    }

    void turnRight(){
        for (Vehicle vehicle : vehicles){
            vehicle.turnRight();
        }
    }

    void setTurboOn(){
        for (Vehicle vehicle : vehicles){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void setTurboOff(){
        for (Vehicle vehicle : vehicles){
            if (vehicle instanceof Saab95){
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void lowerTruckbed(int amount){
        for (Vehicle vehicle : vehicles){
            if (vehicle instanceof Scania){
                ((Scania) vehicle).lower(amount);
            }
        }
    }

    void raiseTruckbed(int amount){
        for (Vehicle vehicle : vehicles){
            if (vehicle instanceof Scania){
                ((Scania) vehicle).raise(amount);
            }
        }
    }

    void turnAllCarsOff(){
        for (Vehicle vehicle : vehicles){
            vehicle.stopEngine();
        }
    }

    void turnAllCarsOn(){
        for (Vehicle vehicle : vehicles){
            vehicle.startEngine();
        }
    }
}
