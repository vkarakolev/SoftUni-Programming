package p04_BubbleSortTest;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testSort() {
        int[] arr = {15, 36, 26, 27, 2, 46, 4, 19};
        Bubble.sort(arr);
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        assertEquals(arr.length, sortedArr.length);
        assertArrayEquals(arr, sortedArr);
    }


}