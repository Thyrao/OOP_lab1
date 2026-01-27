

import java.awt.*;

/* Gemensam funktionalitet extraheras till
 en abstrakt basklass, medan varierande beteende bryts ut till interfaces
 och används via composition för att uppfylla Open–Closed Principle.

 Volvo är en bil → klass + arv
Motor är ett beteende → interface

Interface ska bara beräkna, inte sätta/ändra (?)

*/

interface Engine{
    double incrementSpeed(double currentSpeed, double speedFactor, double amount, double enginePower);
    double decrementSpeed(double currentSpeed, double speedFactor, double amount, double enginePower);
    double speedFactor(double enginePower);
}

abstract class Car implements Movable{
    // variabler
    protected Engine engine;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double posX;
    protected double posY;
    protected double direction;

    public Car(Engine engine, int nrDoors, double enginePower, Color color, String modelName){
        this.engine = engine;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.posX = 0.0;
        this.posY = 0.0;
        this.direction = 0;
        stopEngine();
    }

    // funktioner
    public int getNrDoors() {
        return nrDoors;}

    public double getEnginePower() {
        return enginePower;}

    public double getCurrentSpeed() {
        return currentSpeed;}

    public Color getColor() {
        return color;}

    public void setColor(Color clr) {
        color = clr;}

    public void startEngine(){
        currentSpeed = 0.1;}

    public void stopEngine(){
        currentSpeed = 0;}

    public double speedFactor(){
        return engine.speedFactor(getEnginePower());
    }

    public void incrementSpeed(double amount){
        currentSpeed = engine.incrementSpeed(getCurrentSpeed(), speedFactor(), amount, getEnginePower());
    }

    public void decrementSpeed(double amount){
        currentSpeed = engine.decrementSpeed(getCurrentSpeed(), speedFactor(), amount, getEnginePower());
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        double oldSpeed = getCurrentSpeed();
        if(amount >= 0 && amount <=1){
            incrementSpeed(amount);
            double newSpeed = getCurrentSpeed();
            if(newSpeed < oldSpeed){
                currentSpeed = oldSpeed;
            }
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        double oldSpeed = getCurrentSpeed();
        if(amount >= 0 && amount <=1){
            decrementSpeed(amount);
            double newSpeed = getCurrentSpeed();
            if (newSpeed > oldSpeed){
                currentSpeed = oldSpeed;
            }
        }
    }

    public double getDirection(){
        return direction;
    }

    public void turnRight(){
        direction = (getDirection() + 1)%4;
    }

    public void turnLeft(){
        direction = ((getDirection() - 1)%4 +4) % 4; // kan inte ha modulo på ett negativt tal
    }

    public double[] getPosition(){
        double[] pos = new double[2];
        pos[0] = posX;
        pos[1] = posY;
        return pos;
    }

    public void move(){
        double dir = getDirection();
        double[] pos = getPosition();

        if (dir == 0){
            posY = pos[1] + getCurrentSpeed();
        }
        else if (dir == 1){
            posX = pos[0] + getCurrentSpeed();
        }
        else if (dir == 2){
            posY = pos[1] - getCurrentSpeed();
        }
        else {
            posX = pos[0] - getCurrentSpeed();
        }
    }
}

