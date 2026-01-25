package cars;

import java.awt.*;
import java.awt.geom.Point2D;

public class Saab95 extends Car implements Movable {

    public boolean turboOn;
    public final double rotationSpeed = 2 * Math.PI / 32;
    public final Point2D.Double pos;    // Position of the car in x,y space
    /// An angle of 0 deg means pointing
    /// in positive x-direction.
    /// Incrementing the direction means
    /// rotating counter-clockwise.
    public double dirRad;

    public Saab95(){
        super(2, 125, Color.red, "Saab95");
        turboOn = false;
        pos = new Point2D.Double(0, 0);
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    @Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    @Override
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    @Override
    public void move() {
        pos.setLocation(Math.cos(dirRad) * currentSpeed, Math.sin(dirRad) * currentSpeed);
    }

    @Override
    public void turnLeft() {
        dirRad = (dirRad + rotationSpeed) % (2 * Math.PI);
    }

    @Override
    public void turnRight() {
        dirRad = (dirRad - rotationSpeed) % (2 * Math.PI);
    }
}
