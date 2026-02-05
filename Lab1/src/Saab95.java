import java.awt.*;

public class Saab95 implements Vehicle,Movable {
    private final Car car;
    public Saab95(){
        car = new Car(new SaabEngine(false), 2,  125, Color.red, "Saab95", 3);
    }

    public void setTurboOn(){
        ((SaabEngine) car.engine).setTurbo(true);
    }

    public void setTurboOff(){
        ((SaabEngine) car.engine).setTurbo(false);
    }

    @Override
    public int getNrDoors() {
        return car.getNrDoors();
    }

    public int getCarSize(){
        return car.getCarSize();
    }

    @Override
    public double getEnginePower() {
        return car.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return car.getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return car.color;
    }

    @Override
    public void setColor(Color clr) {
        car.setColor(clr);
    }

    @Override
    public void startEngine() {
        car.startEngine();
    }

    @Override
    public void stopEngine() {
        car.stopEngine();
    }

    @Override
    public void gas(double amount) {
        car.gas(amount);
    }

    @Override
    public void brake(double amount) {
        car.brake(amount);
    }

    @Override
    public double getDirection() {
        return car.getDirection();
    }

    protected  void updatePosition(double x, double y){
        car.updatePosition(x,y);
    }

    @Override
    public void turnRight() {
        car.turnRight();
    }

    @Override
    public void turnLeft() {
        car.turnLeft();
    }

    @Override
    public double[] getPosition() {
        return car.getPosition();
    }

    @Override
    public void move() {
        car.move();
    }

    public double speedFactor() {
        return car.engine.speedFactor(getEnginePower());
    }
}

class SaabEngine implements Engine {

    private boolean turboOn;

    public SaabEngine(boolean turboOn){
        this.turboOn = turboOn;
    }

    protected void setTurbo(boolean turboOn){
        this.turboOn = turboOn;
    }

    @Override
    public double speedFactor(double enginePower){
        double turbo = 1;
        if(turboOn)
            turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
    @Override
    public double incrementSpeed(double currentSpeedx, double speedFactor, double amount, double enginePower){
        return currentSpeedx + speedFactor * amount;
    }
    @Override
    public double decrementSpeed(double currentSpeedx, double speedFactor, double amount, double enginePower){
        return currentSpeedx - speedFactor * amount;
    }
}