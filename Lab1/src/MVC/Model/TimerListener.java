package MVC.Model;

import MVC.Controllers.CarController;
import MVC.Model.Vehicles.CarsPackage.Cars.Volvo240;
import MVC.Model.Vehicles.Vehicle;
import MVC.Views.CarView;
import MVC.Views.Observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TimerListener implements ActionListener {
    private final List<Observer> observers;
    ModelWorld model = new ModelWorld();

    public TimerListener(){
        this.observers = new ArrayList<>();
        observers.add(new CarView("CarSim 1.0", new CarController(model)));
    }

    private void notifyObservers(){
        for (Observer observer: observers){
            observer.update();
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (Vehicle vehicle : model.vehicles.keySet()) {
            vehicle.move();
            int x = (int) Math.round(vehicle.getPosition().x);
            int y = (int) -Math.round(vehicle.getPosition().y); // "-" för att koordinatsystemet är flippat
            //System.out.println(x);
            //System.out.println(y);
                    
            model.bounds(vehicle, x, y);
            notifyObservers();
        }
    }
}