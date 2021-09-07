package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static final Person[] PEOPLE = {new Person(0, "Pesho"), new Person(1, "Gosho")};
    private static final Person VALID_PERSON = PEOPLE[0];

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorCreateValidObject() {
        assertEquals(database.getElements().length, PEOPLE.length);
        for (int i = 0; i < PEOPLE.length; i++) {
            assertEquals(database.getElements()[i], PEOPLE[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWithLessThanOneElement() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWithMoreThanSixteenElements() throws OperationNotSupportedException {
        new Database(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowWhenNullPassed() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowWhenThereIsPersonWithThisId() throws OperationNotSupportedException {
        database.add(new Person(1, "Tosho"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowWhenIdIsNegative() throws OperationNotSupportedException {
        database.add(new Person(-1, "Tosho"));
    }

    @Test
    public void testAddValidPerson() throws OperationNotSupportedException {
        Person person = new Person(2, "Tosho");
        database.add(person);
        Person[] people = database.getElements();
        assertEquals(people.length, PEOPLE.length + 1);
        assertEquals(people[people.length - 1], person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDatabaseThrow() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
    }

    @Test
    public void testRemovedElementShouldBeOnLastIndex() throws OperationNotSupportedException {
        database.remove();

        Person[] elements = database.getElements();
        assertEquals(elements.length, PEOPLE.length - 1);

        int currentLastIndex = elements.length - 1;
        assertEquals(elements[currentLastIndex], PEOPLE[currentLastIndex]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowWhenThereIsNotPersonWithThatName() throws OperationNotSupportedException {
        database.findByUsername("noName");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowWhenNullPassed() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindByUserName() throws OperationNotSupportedException {
        Person person = database.findByUsername(VALID_PERSON.getUsername());
        assertEquals(person, VALID_PERSON);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowIfThereIsNotPersonWithThisId() throws OperationNotSupportedException {
        database.findById(5);
    }

    @Test
    public void testFindById() throws OperationNotSupportedException {
        Person person = database.findById(VALID_PERSON.getId());
        assertEquals(person, VALID_PERSON);
    }
}