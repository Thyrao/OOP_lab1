package MVC.Model.Vehicles;

import MVC.Model.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public interface Vehicle extends Movable{
    int getNrDoors();
    double getEnginePower();
    double getCurrentSpeed();
    Color getColor();
    void setColor(Color clr);
    void startEngine();
    void stopEngine();
    void gas(double amount);
    void brake(double amount);
    double getDirection();
    void turnRight();
    void turnLeft();
    void move();
    void setCurrentSpeed(double amount);
    void updatePosition(double x, double y);
    void updateDirection(double dir);
    void changeState(State state);
    Engine getEngine();
}
