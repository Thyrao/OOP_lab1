package MVC.Controllers;

import MVC.Model.ModelWorld;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    ModelWorld model;

    public CarController(ModelWorld model) {
        this.model = model;
    }
        // Calls the gas method for each car once
    public void gas ( int amount){
        model.gas(amount);
    }

    public void brake ( int amount){
        model.brake(amount);
    }

    public void turnLeft () {
        model.turnLeft();
    }

    public void turnRight () {
        model.turnRight();
    }

    public void setTurboOn () {
        model.setTurboOn();
    }

    public void setTurboOff () {
        model.setTurboOff();
    }

    public void lowerTruckbed ( int amount){
        model.lowerTruckbed(amount);
    }

    public void raiseTruckbed ( int amount){
        model.raiseTruckbed(amount);
    }

    public void turnAllCarsOff () {
        model.turnAllCarsOff();
    }

    public void turnAllCarsOn () {
        model.turnAllCarsOn();
    }

    public void addCar(){
        if(model.getVehicles().size() < 10){
            int randomNum = (int)(Math.random() * 3);
            if (randomNum == 0){
                model.addVolvo();
            }
            else if (randomNum == 1){
                model.addSaab();
            }
            else if (randomNum == 2){
                model.addScania();
            }
        }
    }

    public void removeCar(){
        if(!model.getVehicles().isEmpty()){
            model.removeCar();
        }
    }
    
}
