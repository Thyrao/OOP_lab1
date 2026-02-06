import java.awt.*;
import java.util.ArrayList;

interface Vehicle {
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
    ArrayList<Double> getPosition();
    void move();

}
