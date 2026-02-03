interface Engine{
    double incrementSpeed(double currentSpeed, double speedFactor, double amount, double enginePower);
    double decrementSpeed(double currentSpeed, double speedFactor, double amount, double enginePower);
    double speedFactor(double enginePower);
}
