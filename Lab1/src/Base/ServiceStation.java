package Base;
import Interface.Vehicle;

import java.util.ArrayList;

public class ServiceStation<T extends Vehicle> {
    private ArrayList<T> carsInService;

    public ServiceStation(int maxCapacity){
        this.carsInService = new ArrayList<>(maxCapacity); // osäker
    }

    public ArrayList<T> getAllCarsInService(){
        return carsInService;
    }

    public T fetchCar(T t){
        if (carsInService.contains(t)){
            int i = carsInService.indexOf(t);
            return carsInService.remove(i);
        }
        else return null;
    }

    public void handInCar(T t){
        carsInService.add(t);
    }
}
