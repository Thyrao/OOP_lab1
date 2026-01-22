import java.awt.*;

public class Saab95 extends car {
    public boolean turboOn;

    public Saab95(){
        super(new SaabEngine(), 2,  125, Color.red, "Saab95");
        turboOn = false;}

    public void setTurboOn(){
	    turboOn = true;}

    public void setTurboOff(){
	    turboOn = false;}
}

class SaabEngine implements Engine{
    protected double enginePower;
    public boolean turboOn;

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
    public double incrementSpeed(double currentSpeedx, double speedFactor, double amount){
        return currentSpeedx + speedFactor * amount;
    }

    public double decrementSpeed(double currentSpeedx, double speedFactor, double amount){
        return currentSpeedx - speedFactor * amount;
    }

}