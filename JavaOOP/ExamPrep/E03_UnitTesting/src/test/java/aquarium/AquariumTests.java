package aquarium;

import static org.junit.Assert.*;
import org.junit.Test;

public class AquariumTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsNull() {
        Aquarium aquarium = new Aquarium(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowIfNameIsWhitespace() {
        Aquarium aquarium = new Aquarium("    ", 10);
    }

    @Test
    public void testSetNameShouldSetCorrectName() {
        Aquarium aquarium = new Aquarium("testName", 10);
        assertEquals("testName", aquarium.getName());
    }

    @Test
    public void testSetCapacitySetCorrectCapacity() {
        Aquarium aquarium = new Aquarium("testName", 10);
        assertEquals(10, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowIfCapacityIsLessThanZero() {
        Aquarium aquarium = new Aquarium("testName", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfSizeIsEqualToCapacity() {
        Aquarium aquarium = new Aquarium("testName", 0);
        Fish fish = new Fish("fishName");
        aquarium.add(fish);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowIfFishIsNull() {
        Aquarium aquarium = new Aquarium("testName", 10);
        aquarium.remove("testFish");
    }

    @Test
    public void testRemove() {
        Aquarium aquarium = new Aquarium("testName", 10);
        aquarium.add(new Fish("fish1"));
        aquarium.add(new Fish("fish2"));
        aquarium.remove("fish1");
        assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellShouldThrowIfFishIsNull() {
        Aquarium aquarium = new Aquarium("testName", 10);
        aquarium.sellFish("testFish");
    }

    @Test
    public void testSelFish() {
        Aquarium aquarium = new Aquarium("testName", 10);
        Fish fish = new Fish("fish1");
        aquarium.add(fish);
        aquarium.sellFish("fish1");
        assertFalse(fish.isAvailable());
    }

    @Test
    public void testReportReturnCorrectString() {
        Aquarium aquarium = new Aquarium("testName", 10);
        aquarium.add(new Fish("testFish1"));
        aquarium.add(new Fish("testFish2"));
        aquarium.add(new Fish("testFish3"));

        String expected = "Fish available at testName: testFish1, testFish2, testFish3";
        assertEquals(expected, aquarium.report());

    }
}

