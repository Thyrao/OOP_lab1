import java.awt.*;

public class Saab95 extends Car {
    public Saab95(){
        super(new SaabEngine(false), 2,  125, Color.red, "Saab95");
    }

    public void setTurboOn(){
        ((SaabEngine) engine).setTurbo(true);
    }

    public void setTurboOff(){
        ((SaabEngine) engine).setTurbo(false);
    }
}


class SaabEngine implements Engine{
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