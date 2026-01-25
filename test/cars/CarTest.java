package cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private static class TestCar extends Car {
        public TestCar() {
            super(11, 420, Color.magenta, "TEST COLOR");
        }

        @Override
        void incrementSpeed(double amount) {
            currentSpeed += enginePower * amount;
        }

        @Override
        void decrementSpeed(double amount) {
            currentSpeed -= enginePower * amount;
        }
    }

    TestCar car;

    @BeforeEach
    void setUp() {
        car = new TestCar();
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

    @Test
    void gas_negativeAmountClippedToZero() {
        car.gas(-1);
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void gas_amountGreaterThanOneClippedToOne() {
        car.gas(500);
        assertEquals(car.getEnginePower(), car.getCurrentSpeed());
    }

    @Test
    void brake_negativeAmountClippedToZero() {
        car.gas(1);
        car.brake(-1);
        assertEquals(car.getEnginePower(), car.getCurrentSpeed());
    }

    @Test
    void brake_amountGreaterThanOneClippedToOne() {
        car.gas(1);
        car.brake(500);
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void brake_amountGreaterThanOne_clippedToOne_branchHit() {
        car.gas(0.5);
        car.brake(0.5);
        assertEquals(0, car.getCurrentSpeed(), 0.0001);
    }

}