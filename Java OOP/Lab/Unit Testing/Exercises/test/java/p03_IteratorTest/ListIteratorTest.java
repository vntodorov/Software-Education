package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] TEST_NAMES = {"Stefan", "George", "Maria", "Frank"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(TEST_NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreatingListIteratorWithNullThrowExc() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void testListIteratorHasNextElement() {
        assertTrue(listIterator.hasNext());
    }

    @Test
    public void testListIteratorDoesntHaveNextElement() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMoveListIteratorWithElements(){
        assertTrue(listIterator.move());
    }

    @Test
    public void testMoveListIteratorWithoutElements() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        assertFalse(listIterator.move());
    }

    @Test
    public void testPrintListIteratorWithElements() {
        assertEquals(TEST_NAMES[0], listIterator.print());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintListIteratorWithoutElements() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }


}