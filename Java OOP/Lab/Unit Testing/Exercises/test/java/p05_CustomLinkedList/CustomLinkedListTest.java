package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList<String> list;

    @Before
    public void setUp(){
        list = new CustomLinkedList<>();
        list.add("Pesho");
        list.add("Gosho");
        list.add("Tosho");
    }

    @Test
    public void testAddShouldAdd(){
        int previousSize = list.getCount();
        list.add("Andrei");
        int currentSize = list.getCount();
        assertEquals(list.indexOf("Andrei"), list.getCount() - 1);
        assertEquals(previousSize + 1, currentSize);
    }

    @Test
    public void testGetIndex(){
        assertEquals("Gosho", list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIndexThrowsExcWithNegativeIndex(){
        list.get(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIndexThrowsExcWithBigIndex(){
        list.get(list.getCount() + 1);
    }

    @Test
    public void testSetOnIndex(){
        list.set(1, "Ivan");
        assertEquals("Ivan", list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIndexThrowsExcWithNegativeIndex(){
        list.set(-2, "Toshko");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetIndexThrowsExcWithBigIndex(){
        list.set(list.getCount() + 1, "Koko");
    }

    @Test
    public void testIndexOfShouldFindIndex(){
        assertEquals(1, list.indexOf("Gosho"));
    }

    @Test
    public void testIndexOfShouldNotFindIndex(){
        assertEquals(-1, list.indexOf("Ivan"));
    }

    @Test
    public void testContainsShouldFindItem(){
        assertTrue(list.contains("Gosho"));
    }

    @Test
    public void testContainsShouldNotFindItem(){
        assertFalse(list.contains("Evgeni"));
    }

    @Test
    public void testRemovalWithMissingElement(){
        assertEquals(-1, list.remove("Ivan"));
    }

    @Test
    public void testRemovalWithAvailableElement(){
        assertEquals(2, list.remove("Tosho"));
    }




    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtThrowsExcWithNegativeIndex(){
        list.removeAt(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtThrowsExcWithBigIndex(){
        list.removeAt(list.getCount() + 1);
    }

    @Test
    public void testRemoveAtMethod(){
        assertEquals("Gosho", list.removeAt(1));
    }


}