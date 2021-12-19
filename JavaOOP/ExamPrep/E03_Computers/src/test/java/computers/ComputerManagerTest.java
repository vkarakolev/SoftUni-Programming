package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ComputerManagerTest {
    ComputerManager manager;
    Computer defaultComputer;

    @Before
    public void setUp() {
        manager = new ComputerManager();
        defaultComputer = new Computer("Lenovo", "G50", 500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerThrowWhenAddedComputerIsNull() {
        manager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerThrowWhenAddedComputerAlreadyExists() {
        manager.addComputer(defaultComputer);
        manager.addComputer(defaultComputer);
    }

    @Test
    public void testAddComputerAddsCorrectComputer() {
        assertTrue(manager.getComputers().isEmpty());
        manager.addComputer(defaultComputer);
        assertTrue(manager.getComputers().contains(defaultComputer));
    }

    @Test
    public void testGetComputersShouldReturnListWithAllComputers() {
        Computer c1 = new Computer("Asus", "G50", 600);
        Computer c2 = new Computer("Dell", "G50", 700);

        manager.addComputer(defaultComputer);
        manager.addComputer(c1);
        manager.addComputer(c2);
        List<Computer> result = manager.getComputers();

        assertEquals(manager.getCount(), result.size());
        assertEquals(defaultComputer, result.get(0));
        assertEquals(c1, result.get(1));
        assertEquals(c2, result.get(2));
    }

    @Test
    public void testRemoveComputerRemovesCorrectComputer() {
        manager.addComputer(defaultComputer);
        Computer removed = manager.removeComputer("Lenovo", "G50");

        assertTrue(manager.getComputers().isEmpty());
        assertEquals(defaultComputer, removed);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowWhenManufacturerIsNull() {
        manager.addComputer(defaultComputer);
        manager.getComputer(null, "G50");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowWhenModelIsNull() {
        manager.addComputer(defaultComputer);
        manager.getComputer("Lenovo", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowWhenGivenComputerNotExist() {
        manager.addComputer(defaultComputer);
        manager.getComputer("Lenovo", "notExisting");
    }

    @Test
    public void testGetComputerReturnsCorrectComputer() {
        manager.addComputer(defaultComputer);
        Computer result = manager.getComputer("Lenovo", "G50");

        assertEquals(defaultComputer, result);
    }

    @Test
    public void testGetByManufacturerReturnsCorrectResult() {
        manager.addComputer(defaultComputer);
        manager.addComputer(new Computer ("Lenovo", "model1", 100));
        manager.addComputer(new Computer ("Dell", "model1", 100));
        manager.addComputer(new Computer ("Lenovo", "model2", 100));
        manager.addComputer(new Computer ("Asus", "model1", 100));

        List<Computer> expected = manager.getComputers().stream()
                .filter(c -> c.getManufacturer().equals("Lenovo"))
                .collect(Collectors.toList());

        List<Computer> actual = manager.getComputersByManufacturer("Lenovo");

        assertEquals(expected.size(), actual.size());
        assertEquals(expected,actual);
    }
}