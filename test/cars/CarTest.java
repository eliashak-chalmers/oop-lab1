package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static class TestCar extends Car {
        public TestCar(int nrDoors, double enginePower, Color color, String modelName) {
            super(nrDoors, enginePower, color, modelName);
        }
    }

    TestCar car;

    @BeforeEach
    void setUp() {
        car = new TestCar(11, 420, Color.magenta, "TEST CAR");
    }

    @Test
    void getNrDoors() {
        assertEquals(11, car.getNrDoors());
    }

    @Test
    void getEnginePower() {
        assertEquals(420, car.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void getColor() {
        assertEquals(Color.magenta, car.getColor());
    }

    @Test
    void setColor() {
        car.setColor(Color.yellow);
        assertEquals(Color.yellow, car.getColor());
    }

    @Test
    void startEngine() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }
}