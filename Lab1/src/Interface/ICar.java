package Interface;
import Interface.Vehicle;

public interface ICar extends Vehicle {
    void updatePosition(double x, double y);
    int getCarSize();

}
