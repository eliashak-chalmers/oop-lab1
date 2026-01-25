import java.awt.*;
import java.awt.geom.Point2D;

public class Volvo240 extends Car implements Movable {

    public final static double trimFactor = 1.25;
    // An angle of 0 deg means pointing
    // in positive y-direction.
    // Incrementing the direction means
    // rotating clockwise.
    private final double rotationSpeed = 2 * Math.PI / 32;
    private Point2D pos;    // Position of the car in x,y space
    private double dirRad;  // Direction of the car in radians.

    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
    }

    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void move() {
        pos.setLocation(Math.cos(dirRad) * currentSpeed, Math.sin(dirRad) * currentSpeed);
    }

    public void turnLeft() {
        dirRad = (dirRad - rotationSpeed) % (2 * Math.PI);
    }

    public void turnRight() {
        dirRad = (dirRad + rotationSpeed) % (2 * Math.PI);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
