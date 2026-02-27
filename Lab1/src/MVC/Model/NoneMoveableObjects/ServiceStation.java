package MVC.Model.NoneMoveableObjects;
import MVC.Model.LoadedState;
import MVC.Model.UnloadedState;
import MVC.Model.Vehicles.Vehicle;

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
            t.changeState(new UnloadedState(t, t.getEngine()));
            return carsInService.remove(i);
        }
        else return null;
    }

    public void handInCar(T t){
        if(carsInService.size() < maxCapacity){
            carsInService.add(t);
            t.changeState(new LoadedState(t));
        }
    }
}
