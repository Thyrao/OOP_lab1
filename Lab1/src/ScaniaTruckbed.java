class ScaniaTruckbed{
    protected double angle;
    public ScaniaTruckbed(){
        this.angle = 0;
    }

    public void lower(double amount, double currentSpeed) {
        if (currentSpeed == 0) {
            angle -= amount;
            if  (angle < 0)
                angle = 0;
        }
    }

    public void raise(double amount, double currentSpeed) {
        if (currentSpeed == 0){
            angle += amount;
            if (angle > 70)
                angle = 70;
        }
    }

    public double getAngle() {
        return angle;
    }
}
