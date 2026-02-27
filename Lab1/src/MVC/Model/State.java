package MVC.Model;

public interface State {
    void turnRight();
    void turnLeft();
    void move();
    void gas(double amount);
    void brake(double amount);
    void startEngine();
}
