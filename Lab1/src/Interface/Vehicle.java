package Interface;

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
    List<Double> getPosition();
    void move();
    void setCurrentSpeed(double amount);

}
