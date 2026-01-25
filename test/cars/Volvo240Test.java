package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    Volvo240 car;

    @BeforeEach
    void setUp() {
        car = new Volvo240();
    }

    @Test
    void speedFactor() {
        assertEquals(car.enginePower * 0.01 * 1.25, car.speedFactor());
    }

    @Test
    void incrementSpeed_smallAmount() {
        car.currentSpeed = 10;
        car.incrementSpeed(5);
        assertEquals(10 + 5 * car.speedFactor(), car.currentSpeed);
    }

    @Test
    void incrementSpeed_largeAmount() {
        car.currentSpeed = 30;
        car.incrementSpeed(500);
        assertEquals(car.enginePower, car.currentSpeed);
    }

    @Test
    void decrementSpeed_smallAmount() {
        car.currentSpeed = 50;
        car.decrementSpeed(5);
        assertEquals(50 - 5 * car.speedFactor(), car.currentSpeed);
    }

    @Test
    void decrementSpeed_largeAmount() {
        car.currentSpeed = 30;
        car.decrementSpeed(40);
        assertEquals(0, car.currentSpeed);
    }

    @Test
    void move_negativeY() {
        car.currentSpeed = 10;
        car.dirRad = 3 * Math.PI / 2;
        car.move();
        assertEquals(0, car.pos.x, 1e-10);
        assertEquals(-10, car.pos.y);
    }

    @Test
    void turnLeft() {
        car.dirRad = 0;
        car.turnLeft();
        assertEquals(-1 * car.rotationSpeed, car.dirRad);
        car.turnLeft();
        assertEquals(-2 * car.rotationSpeed, car.dirRad);
    }

    @Test
    void turnRight() {
        car.dirRad = 0;
        car.turnRight();
        assertEquals(1 * car.rotationSpeed, car.dirRad);
        car.turnRight();
        assertEquals(2 * car.rotationSpeed, car.dirRad);
    }

    @Test
    void gas() {
        Volvo240 other = new Volvo240();
        for(int i = 0; i < 20; i++) {
            car.gas(20);
            other.incrementSpeed(20);
            assertEquals(other.currentSpeed, car.currentSpeed);
        }
    }

    @Test
    void brake() {
        Volvo240 other = new Volvo240();
        for(int i = 0; i < 20; i++) {
            car.brake(20);
            other.decrementSpeed(20);
            assertEquals(other.currentSpeed, car.currentSpeed);
        }
    }

}