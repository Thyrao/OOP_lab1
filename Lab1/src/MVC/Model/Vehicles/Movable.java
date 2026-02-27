package MVC.Model.Vehicles;

import MVC.Model.State;
import java.util.List;

public interface Movable extends State {
    void turnRight();
    void turnLeft();
    void move();
    List<Double> getPosition();
}
