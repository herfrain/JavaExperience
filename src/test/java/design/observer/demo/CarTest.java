package design.observer.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void update() {
        Light light = new Light();
        Car car1 = new Car(light);
        Car car2 = new Car(light);
        Car car3 = new Car(light);
        light.setColor("Yellow");
        light.setColor("Red");
        light.setColor("Green");
    }
}