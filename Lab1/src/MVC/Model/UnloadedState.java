package MVC.Model;

import MVC.Model.Vehicles.Vehicle;
import MVC.Model.Vehicles.Engine;

public class UnloadedState implements State{
    Vehicle vehicle;
    Engine engine;

    public UnloadedState(Vehicle vehicle, Engine engine) {
        this.vehicle = vehicle;
        this.engine = engine;
    }

    public void turnRight(){
        double direction;
        direction = (vehicle.getDirection() + 1)%4;
        vehicle.updateDirection(direction);
    }

    public void turnLeft(){
        double direction;
        direction = ((vehicle.getDirection() - 1)%4 +4) % 4;
        vehicle.updateDirection(direction);
    }

    public void move(){
        double posY = vehicle.getPosition().getFirst();
        double posX = vehicle.getPosition().getLast();
        double dir = vehicle.getDirection();

        if (dir == 0){
            posY +=  vehicle.getCurrentSpeed();
            vehicle.updatePosition(posX, posY);
        }
        else if (dir == 1){
            posX -= vehicle.getCurrentSpeed();
            vehicle.updatePosition(posX, posY);
        }
        else if (dir == 2){
            posY -= vehicle.getCurrentSpeed();
            vehicle.updatePosition(posX, posY);
        }
        else {
            posX += vehicle.getCurrentSpeed();
            vehicle.updatePosition(posX, posY);
        }
    }

    public void gas(double amount){
        double oldSpeed = vehicle.getCurrentSpeed();
        if(amount >= 0 && amount <=1){
            double newSpeed = engine.incrementSpeed(vehicle.getCurrentSpeed(), engine.speedFactor(vehicle.getEnginePower()), amount, vehicle.getEnginePower());
            if(newSpeed < oldSpeed){
               vehicle.setCurrentSpeed(oldSpeed);
            }
            else if (newSpeed > vehicle.getEnginePower()){
                vehicle.setCurrentSpeed(vehicle.getEnginePower());
            }
            else vehicle.setCurrentSpeed(newSpeed);
        }
    }
    public void brake(double amount){
        double oldSpeed = vehicle.getCurrentSpeed();
        if(amount >= 0 && amount <=1){
            double newSpeed = engine.decrementSpeed(vehicle.getCurrentSpeed(), engine.speedFactor(vehicle.getEnginePower()), amount, vehicle.getEnginePower());
            if (newSpeed > oldSpeed){
                vehicle.setCurrentSpeed(oldSpeed);
            }
            else if (newSpeed < 0){
                vehicle.setCurrentSpeed(0);
            }
            else vehicle.setCurrentSpeed(newSpeed);
        }
    }

}
