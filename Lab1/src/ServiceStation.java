import java.util.ArrayList;

public class ServiceStation<T> {
    private int maxCapacity;
    private ArrayList<T> carsInService;

    public ServiceStation(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.carsInService = new ArrayList<>(maxCapacity); // osäker
    }

    ArrayList<T> getAllCarsInService(){
        return carsInService;
    }

    T fetchCar(T t){
        if (carsInService.contains(t)){
            int i = carsInService.indexOf(t);
            return carsInService.remove(i);
        }
        else return null;
    }

    void handInCar(T t){
        carsInService.add(t);
    }
}
