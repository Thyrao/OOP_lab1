package MVC.Model;

import MVC.Model.Vehicles.Vehicle;
import MVC.Views.Observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TimerListener implements ActionListener {
    private final List<Observer> observers;
    ModelWorld model;

    public TimerListener(ModelWorld model){
        this.observers = new ArrayList<>();
        this.model = model;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    private void notifyObservers(){
        for (Observer observer: observers){
            observer.update();
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (Vehicle vehicle : model.getVehicles().keySet()) {
            vehicle.move();
            int x = (int) Math.round(vehicle.getPosition().getFirst());
            int y = (int) Math.round(vehicle.getPosition().getLast()); // "-" för att koordinatsystemet är flippat

            model.bounds(vehicle, x, y);
            notifyObservers();
        }
    }
}