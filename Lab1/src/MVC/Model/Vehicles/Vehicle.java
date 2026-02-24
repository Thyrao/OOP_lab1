package MVC.Model.Vehicles;

import java.awt.*;
import java.util.List;

public interface Vehicle {
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
    Point getPosition();
    void move();
    void setCurrentSpeed(double amount);
    void updatePosition(int x, int y);

}
