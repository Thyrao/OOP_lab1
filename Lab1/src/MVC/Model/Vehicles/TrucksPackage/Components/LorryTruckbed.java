package MVC.Model.Vehicles.TrucksPackage.Components;
import MVC.Model.LoadedState;
import MVC.Model.UnloadedState;
import MVC.Model.Vehicles.CarsPackage.Components.ICar;

import java.util.ArrayList;
import java.util.List;

public class LorryTruckbed{
    protected boolean angle;
    private final List<ICar> loadedCars;
    private final int maxCapacity;

    public LorryTruckbed(){
        this.angle = false;
        this.loadedCars = new ArrayList<>();
        this.maxCapacity = 5;
    }

    public void lower(double currentSpeed) {
        if (currentSpeed == 0) {
            angle = false;
        }
    }

    public void raise(double currentSpeed) {
        if (currentSpeed == 0){
            angle = true;
        }
    }

    public boolean getAngle() {
        return angle;
    }

    public void load(ICar car, List<Double> position) {
        if (loadedCars.size() < maxCapacity) {
            if ((Math.abs(car.getPosition().getFirst() - position.getFirst()) < 1) && (Math.abs(car.getPosition().getLast() - position.getLast()) < 1)) {
                if (angle && !loadedCars.contains(car))
                    if (car.getCarSize() < 5)
                        loadedCars.add(car);
                        car.changeState(new LoadedState(car));
            }
        }
    }

    public ICar unload(){
        ICar unloadedCar;
        if (angle) {
            if (!getLoadedCars().isEmpty()) {
                unloadedCar = getLoadedCars().removeLast();
                unloadedCar.getPosition();
                unloadedCar.updatePosition(unloadedCar.getPosition().get(0)+1, unloadedCar.getPosition().get(1)+1);
                unloadedCar.changeState(new UnloadedState(unloadedCar, unloadedCar.getEngine()));
                return unloadedCar;
            }
        }
        return null;
    }

    public List<ICar> getLoadedCars() {
        return loadedCars;
    }
}
