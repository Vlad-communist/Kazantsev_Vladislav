package list_sorting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {

    @Test
    void testBubbleSort() throws Exception {
        List<Integer> arr = Arrays.asList(5, 3, 8, 1, 2);
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 8);
        List<Integer> result = Sorts.sortAscending(arr, "bubble");
        assertEquals(expected, result, "Bubble sort did not sort correctly.");
    }

    @Test
    void testMergeSort() throws Exception {
        List<Integer> arr = Arrays.asList(10, 7, 5, 3, 1);
        List<Integer> expected = Arrays.asList(1, 3, 5, 7, 10);
        List<Integer> result = Sorts.sortAscending(arr, "merge");
        assertEquals(expected, result, "Merge sort did not sort correctly.");
    }

    @Test
    void testUnknownSortType() {
        List<Integer> arr = Arrays.asList(9, 3, 7, 2, 1);
        Executable executable = () -> Sorts.sortAscending(arr, "digital");;
        assertThrows(Exception.class, executable, "SortAscending function should throw an exception for unknown sort type");
    }

    @Test
    void testBubbleSortSizeLimit() {
        List<Integer> oversizedArray = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            oversizedArray.add(101 - i);
        }

        Executable executable = () -> Sorts.bubbleSortAscending(oversizedArray);
        assertThrows(Exception.class, executable, "Bubble sort should throw an exception for oversized array.");
    }

    @Test
    void testMergeSortSizeLimit() {
        List<Integer> oversizedArray = new ArrayList<>();
        for (int i = 0; i < 201; i++) {
            oversizedArray.add(201 - i);
        }

        Executable executable = () -> Sorts.mergeSortAscending(oversizedArray);
        assertThrows(Exception.class, executable, "Merge sort should throw an exception for oversized array.");
    }

    @Test
    void testGetSortTypes() {
        String[] expectedTypes = {"bubble", "merge"};
        assertArrayEquals(expectedTypes, Sorts.getAscendingSortTypes(), "Sort types array does not match the expected types.");
    }
}
