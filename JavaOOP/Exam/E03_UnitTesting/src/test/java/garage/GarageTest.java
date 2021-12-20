package garage;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class GarageTest {
    private Garage garage;
    private Car defaultCar;

    @Before
    public void setUp() {
        garage = new Garage();
        defaultCar = new Car("Audi", 220, 2000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarThrowWhenCarIsNull() {
        garage.addCar(null);
    }
    
    @Test
    public void testAddCarAddsCorrectCar() {
        assertTrue(garage.getCars().isEmpty());
        garage.addCar(defaultCar);
        assertEquals(defaultCar, garage.getCars().get(0));
        assertEquals(1, garage.getCount());
    }

    @Test
    public void testFindAllCarsWithMaxSpeedAboveFindsCorrectCars() {
        Car car1 = new Car("Opel", 150, 500);
        Car car2 = new Car("Audi", 240, 500);
        Car car3 = new Car("Bmw", 250, 500);
        Car car4 = new Car("Audi", 150, 500);

        garage.addCar(defaultCar);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);

        List<Car> expected = garage.getCars().stream()
                .filter(c -> c.getMaxSpeed() > 200)
                .collect(Collectors.toList());

        List<Car> actual = garage.findAllCarsWithMaxSpeedAbove(200);

        assertEquals(expected.size(), actual.size());
        assertEquals(defaultCar, actual.get(0));
        assertEquals(car2, actual.get(1));
        assertEquals(car3, actual.get(2));
    }

    @Test
    public void testGetMostExpensiveCarReturnsCorrectCar() {
        fillGarage(garage);

        Car expected = garage.getCars().stream()
                .max(Comparator.comparingDouble(Car::getPrice))
                .orElse(null);

        Car actual = garage.getTheMostExpensiveCar();

        assertEquals(expected, actual);
    }

    @Test
    public void testFindCarsByBrand() {
        fillGarage(garage);

        List<Car> expected = garage.getCars().stream()
                .filter(c -> c.getBrand().equals("Audi"))
                .collect(Collectors.toList());

        List<Car> actual = garage.findAllCarsByBrand("Audi");

        assertEquals(expected.size(), actual.size());
        assertEquals("Audi", actual.get(0).getBrand());
        assertEquals("Audi", actual.get(1).getBrand());
        assertEquals("Audi", actual.get(2).getBrand());
    }

    public static void fillGarage(Garage garage) {
        Car defaultCar = new Car("Audi", 220, 2000);
        Car car1 = new Car("Opel", 150, 500);
        Car car2 = new Car("Audi", 240, 500);
        Car car3 = new Car("Bmw", 250, 500);
        Car car4 = new Car("Audi", 150, 500);

        garage.addCar(defaultCar);
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);
        garage.addCar(car4);
    }
}