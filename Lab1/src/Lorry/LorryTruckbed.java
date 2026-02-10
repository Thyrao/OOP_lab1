package Lorry;
import Interface.ICar;

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
            if ((Math.abs(car.getPosition().get(0) - position.get(0)) < 1) && (Math.abs(car.getPosition().get(1) - position.get(1)) < 1)) {
                if (angle && !loadedCars.contains(car))
                    if (car.getCarSize() < 5)
                        loadedCars.add(car);
            }
        }
    }

    public ICar unload(){
        ICar unloadedCar;
        if (angle) {
            if (!getLoadedCars().isEmpty()) {
                unloadedCar = getLoadedCars().removeLast();
                unloadedCar.updatePosition(unloadedCar.getPosition().get(0)+1, unloadedCar.getPosition().get(1)+1);
                return unloadedCar;
            }
        }
        return null;
    }

    public List<ICar> getLoadedCars() {
        return loadedCars;
    }
}
