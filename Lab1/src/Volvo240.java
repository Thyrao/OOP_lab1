import java.awt.*;

public class Volvo240 extends car{
    public Volvo240(){
        super(new VolvoEngine(), 4, 100, Color.black, "Volvo240");
    }
}

class VolvoEngine implements Engine{
    protected double enginePower;

    public final static double trimFactor = 1.25;

    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
    public double incrementSpeed(double currentSpeedx, double speedFactor, double amount){
        return Math.min(currentSpeedx + speedFactor * amount,enginePower);
    }

    public double decrementSpeed(double currentSpeedx, double speedFactor, double amount){
        return Math.max(currentSpeedx - speedFactor * amount,0);
    }

}