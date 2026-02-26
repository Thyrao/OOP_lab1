package MVC.Model.Vehicles;

import java.util.List;

public interface Movable{
    void turnRight();
    void turnLeft();
    void move();
    List<Double> getPosition();
}
