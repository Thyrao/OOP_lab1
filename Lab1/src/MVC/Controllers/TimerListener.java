package MVC.Controllers;

import MVC.Vehicles.CarsPackage.Cars.Volvo240;
import MVC.Vehicles.Vehicle;
import MVC.Views.CarView;
import MVC.Views.Observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TimerListener implements ActionListener {
    double g;
    List<Observer> observers;

    public TimerListener(){
        this.observers = new ArrayList<>();
        observers.add(new CarView("CarSim 1.0", new CarController()));
    }
    public void notifyObservers(){
        for (Observer observer: observers){
            observer.update();
        }
    }

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