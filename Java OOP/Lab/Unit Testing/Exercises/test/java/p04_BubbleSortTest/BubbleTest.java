package p04_BubbleSortTest;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BubbleTest {

    private static final int[] TEST_UNSORTED_NUMBERS = {2, 6, 4, 7, 1, 3, 5};

    @Test
    public void testBubbleSort() {
        Bubble.sort(TEST_UNSORTED_NUMBERS);
        int[] TEST_NUMBERS_SORTED = {1, 2, 3, 4, 5, 6, 7};
        assertArrayEquals(TEST_UNSORTED_NUMBERS, TEST_NUMBERS_SORTED);
    }

}