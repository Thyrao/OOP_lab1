import java.awt.*;

class Truck implements Movable,Vehicle,Truckbed{
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
    protected double angle;

    public Truck(Engine engine, int nrDoors, double enginePower, Color color, String modelName){
        this.engine = engine;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.posX = 0.0;
        this.posY = 0.0;
        this.direction = 0;
        this.angle = 0;
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

    protected double speedFactor(){
        return engine.speedFactor(getEnginePower());
    }

    protected void incrementSpeed(double amount){
        if (angle > 0){
            currentSpeed = 0;
        }
        else{ currentSpeed = engine.incrementSpeed(getCurrentSpeed(), speedFactor(), amount, getEnginePower());}
    }

    protected void decrementSpeed(double amount){
        currentSpeed = engine.decrementSpeed(getCurrentSpeed(), speedFactor(), amount, getEnginePower());
    }

    public void gas(double amount){
        double oldSpeed = getCurrentSpeed();
        if(amount >= 0 && amount <=1){
            incrementSpeed(amount);
            double newSpeed = getCurrentSpeed();
            if(newSpeed < oldSpeed){
                currentSpeed = oldSpeed;
            }
            else if (newSpeed > getEnginePower()){
                currentSpeed = getEnginePower();
            }
        }
    }

    public void brake(double amount){
        double oldSpeed = getCurrentSpeed();
        if(amount >= 0 && amount <=1){
            decrementSpeed(amount);
            double newSpeed = getCurrentSpeed();
            if (newSpeed > oldSpeed){
                currentSpeed = oldSpeed;
            }
            else if (newSpeed < 0){
                currentSpeed = 0;
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

    public void lower(double amount) {
        if (getCurrentSpeed() == 0) {
            angle -= amount;
            if  (angle < 0)
                angle = 0;
        }
        //else throw new RuntimeException("The Truck must first stand still ");
    }

    public void raise(double amount) {
        if (getCurrentSpeed() == 0){
            angle += amount;
            if (angle > 70)
                angle = 70;
        }
        //else throw new RuntimeException("The Truck must first stand still ");
    }

    @Override
    public double getAngle() {
        return angle;
    }

}

