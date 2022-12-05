package p02_ExtendedDatabase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Person pesho = new Person(1, "Pesho");
    private static final Person tosho = new Person(2, "Tosho");
    private static final Person gosho = new Person(3, "Gosho");

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(pesho, tosho, gosho);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindNullUsernameThrowExc() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByNonExistingUsernameThrowExc() throws OperationNotSupportedException {
        database.findByUsername("Kaloyan");
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        Person person = database.findByUsername(pesho.getUsername());
        assertEquals(pesho, person);
    }


}
