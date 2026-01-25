package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {

    Saab95 car;

    @BeforeEach
    void setUp() {
        car = new Saab95();
    }

    @Test
    void setTurboOn() {
        car.setTurboOn();
        assertTrue(car.turboOn);
    }

    @Test
    void setTurboOff() {
        car.setTurboOff();
        assertFalse(car.turboOn);
    }

    @Test
    void speedFactor_turboOn() {
        car.setTurboOn();
        double expected = car.getEnginePower() * 0.01 * 1.3;
        assertEquals(expected, car.speedFactor());
    }

    @Test
    void speedFactor_turboOff() {
        car.setTurboOff();
        double expected = car.getEnginePower() * 0.01;
        assertEquals(expected, car.speedFactor());
    }

    @Test
    void incrementSpeed() {
        car.incrementSpeed(250.25);
        assertEquals(1 * 250.25 * car.speedFactor(), car.currentSpeed);
        car.incrementSpeed(250.25);
        assertEquals(2 * 250.25 * car.speedFactor(), car.currentSpeed);
    }

    @Test
    void decrementSpeed() {
        car.decrementSpeed(250.25);
        assertEquals(1 * -250.25 * car.speedFactor(), car.getCurrentSpeed());
        car.decrementSpeed(250.25);
        assertEquals(2 * -250.25 * car.speedFactor(), car.getCurrentSpeed());
    }

    @Test
    void move_positiveY() {
        car.currentSpeed = 10;
        car.dirRad = Math.PI / 2;
        car.move();
        assertEquals(0, car.pos.x, 1e-10);
        assertEquals(10, car.pos.y, 1e-10);
    }


    @Test
    void move_positiveX() {
        car.currentSpeed = 5;
        car.dirRad = 0;
        car.move();
        assertEquals(new Point2D.Double(5, 0), car.pos);
    }

    @Test
    void turnLeft() {
        car.dirRad = 0;
        car.turnLeft();
        assertEquals(1 * car.rotationSpeed, car.dirRad);
        car.turnLeft();
        assertEquals(2 * car.rotationSpeed, car.dirRad);
        car.turnLeft();
        assertEquals(3 * car.rotationSpeed, car.dirRad);
    }

    @Test
    void turnRight() {
        car.dirRad = 0;
        car.turnRight();
        assertEquals(-1 * car.rotationSpeed, car.dirRad);
        car.turnRight();
        assertEquals(-2 * car.rotationSpeed, car.dirRad);
        car.turnRight();
        assertEquals(-3 * car.rotationSpeed, car.dirRad);
    }
}