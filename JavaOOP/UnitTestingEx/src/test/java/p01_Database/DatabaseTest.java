package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {1, 2, 3, 4, 5, 6,};
    private static final Integer VALID_ELEMENT = 16;

    private Database database;
    private Database oneElementDatabase;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);

        oneElementDatabase = new Database(1);
    }

    @Test
    public void testConstructorCreateValidObject() {
        Integer[] databaseElements = database.getElements();

        assertEquals(databaseElements.length, NUMBERS.length);

        for (int i = 0; i < databaseElements.length; i++) {
            assertEquals(databaseElements[i], NUMBERS[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSetMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSetLessThenOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowWhenParameterEqualsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddValidElementAtTheNextFreeCell() throws OperationNotSupportedException {
        database.add(VALID_ELEMENT);

        int currentLength = database.getElements().length;
        int expectedLength = NUMBERS.length + 1;
        assertEquals(currentLength, expectedLength);

        int addIndex = currentLength - 1;
        assertEquals(VALID_ELEMENT, database.getElements()[addIndex]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDatabaseThrow() throws OperationNotSupportedException {
        oneElementDatabase.remove();
        oneElementDatabase.remove();
    }

    @Test
    public void testRemovedElementShouldBeOnLastIndex() throws OperationNotSupportedException {
        database.remove();

        Integer[] elements = database.getElements();
        assertEquals(elements.length, NUMBERS.length - 1);

        int currentLastIndex = elements.length - 1;
        assertEquals(elements[currentLastIndex], NUMBERS[currentLastIndex]);
    }
}