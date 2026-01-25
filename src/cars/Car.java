package cars;
import java.awt.*;

public abstract class Car {
    public int nrDoors;             // Number of doors on the car
    public double enginePower;      // Engine power of the car
    public double currentSpeed;     // The current speed of the car
    public Color color;             // Color of the car
    public String modelName;

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    abstract void incrementSpeed(double amount);

    abstract void decrementSpeed(double amount);

    /**
     * Increments speed by some amount. Guarantees that currentSpeed remains within [0, enginePower].
     * @param amount - How much to increment the speed. Accepts values in the range [0, 1] and otherwise clips the value into that range.
     */
    public void gas(double amount){
        if(amount < 0) amount = 0;
        if(amount > 1) amount = 1;
        incrementSpeed(amount);
        currentSpeed = Math.min(currentSpeed, enginePower);
    }

    /**
     * Decrements speed by some amount. Guarantees that currentSpeed remains within [0, enginePower].
     * @param amount - How much to decrement the speed. Accepts values in the range [0, 1] and otherwise clips the value into that range.
     */
    public void brake(double amount){
        if(amount < 0) amount = 0;
        else if (amount > 1) amount = 1;
        decrementSpeed(amount);
        currentSpeed = Math.max(currentSpeed, 0);
    }
}
