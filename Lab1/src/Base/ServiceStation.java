package Base;
import Interface.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ServiceStation<T extends Vehicle> {
    private final List<T> carsInService;
    private final int maxCapacity;

    public ServiceStation(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.carsInService = new ArrayList<>();
    }

    public List<T> getAllCarsInService(){
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
        if(carsInService.size() < maxCapacity){
            carsInService.add(t);
        }
    }
}
