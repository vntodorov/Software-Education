package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;
    private static final Integer[] TEST_ELEMENTS = {1, 2, 3, 4, 5};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(TEST_ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testInstantiatingDatabaseWithoutElementsThrowsExc() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testInstantiatingDatabaseWithMoreThan16ElementsThrowsExc() throws OperationNotSupportedException {
        database = new Database(new Integer[17]);
    }

    @Test
    public void testInstantiatingDatabaseAndGettingItsElements() {
        assertArrayEquals(TEST_ELEMENTS, database.getElements());
    }

    @Test
    public void testAddElement() throws OperationNotSupportedException {
        database.add(6);
        int lastElement = database.getElements()[database.getElements().length - 1];
        assertEquals(6, lastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElementThrowsExc() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveElement() throws OperationNotSupportedException {
        database.remove();
        assertEquals(TEST_ELEMENTS.length - 1, database.getElements().length);
        assertEquals(TEST_ELEMENTS[TEST_ELEMENTS.length - 2], database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabase() throws OperationNotSupportedException {
        database = new Database(1);
        database.remove();
        database.remove();
    }

}