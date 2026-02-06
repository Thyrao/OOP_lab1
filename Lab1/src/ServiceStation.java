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

    T getCar(T t){
        if (carsInService.contains(t)){
            for(int i=0; i < carsInService.size(); i++){
                if (carsInService.get(i) == t){
                    return carsInService.remove(i);
                }
            }
        }
        else throw new RuntimeException("Car not in service");
        //return t;
    }

    void handInCar(T t){
        carsInService.add(t);
    }
}
