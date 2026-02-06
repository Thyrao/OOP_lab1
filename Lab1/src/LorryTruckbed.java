import java.util.ArrayList;

class LorryTruckbed{
    protected double angle;
    private final ArrayList<ICar> loadedCars;

    public LorryTruckbed(){
        this.angle = 0;
        this.loadedCars = new ArrayList<>(5);
    }

    public void lower(double currentSpeed) {
        if (currentSpeed == 0) {
            angle = 0;
        }
    }

    public void raise(double currentSpeed) {
        if (currentSpeed == 0){
            angle = 70;
        }
    }

    public double getAngle() {
        return angle;
    }

    public void load(ICar car, ArrayList<Double> position){ // hum...
        if ((Math.abs(car.getPosition().get(0) - position.get(0)) < 1) && (Math.abs(car.getPosition().get(1) - position.get(1)) < 1)){
            if (angle == 70 && !loadedCars.contains(car))
                if (car.getCarSize() < 5)
                    loadedCars.add(car); // vad händer när listan är full och vi försöker lasta en ny eller samma bil?
        }
    }

    public ICar unload(){
        ICar unloadedCar;
        if (angle == 70) {
            if (!getLoadedCars().isEmpty()) {
                unloadedCar = getLoadedCars().removeLast();
                unloadedCar.updatePosition(unloadedCar.getPosition().get(0)+1, unloadedCar.getPosition().get(1)+1);
                return unloadedCar;
            }
        }
        return null;
    }

    public ArrayList<ICar> getLoadedCars() {
        return loadedCars;
    }
}
