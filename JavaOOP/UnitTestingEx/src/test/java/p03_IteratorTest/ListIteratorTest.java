package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private static final String[] WORDS = {"first", "second"};
    private static final int START_INDEX = 0;

    private ListIterator iterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        iterator = new ListIterator(WORDS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenPassedNull() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testMoveReturnTrueWhenHasNextAndFalseWhenOnLastIndex() {
        assertTrue(iterator.move());
        assertFalse(iterator.move());
    }

    @Test
    public void testPrintCurrentElement() {
        assertEquals(iterator.print(), WORDS[START_INDEX]);
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyCollectionThrow() throws OperationNotSupportedException {
        new ListIterator(new String[0]).print();
    }
}