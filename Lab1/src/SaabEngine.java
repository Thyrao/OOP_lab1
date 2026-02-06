class SaabEngine implements Engine,Turbo {
    private boolean turboOn;

    public SaabEngine(boolean turboOn){
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

    @Override
    public void setTurboOn() {
        turboOn = true;
    }

    @Override
    public void setTurboOff() {
        turboOn = false;
    }
}