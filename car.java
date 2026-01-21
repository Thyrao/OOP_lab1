import java.awt.*;
import java.io.*;

/* Gemensam funktionalitet extraheras till
 en abstrakt basklass, medan varierande beteende bryts ut till interfaces
 och används via composition för att uppfylla Open–Closed Principle.

 Volvo är en bil → klass + arv
Motor är ett beteende → interface

*/
interface Speed{
    void speedFactor();
}
interface Engine{
   void incrementSpeed(double amount);
   void decrementSpeed(double amount);
   int getCurrentSpeed();
   int speedFactor();

}

abstract class car {
    // variabler
    protected Engine engine;
    protected Speed speed;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

    public car(Engine engine, Speed speed, int nrDoors, double enginePower, double currentSpeed, Color color, String modelName){
        this.engine = engine;
        this.speed = speed;
        this.nrDoors = nrDoors;
        this.enginePower = enginePower; //kanske ta bort
        this.currentSpeed = currentSpeed; // kanske ta bort
        this.color = color;
        this.modelName = modelName;
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

}
