package lab1.quicksort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class QSTraceTest {

    private final QuickSort quickSort = new QuickSort();

    @Test
    void qstraceSingleElementTest() {
        int[] input = new int[]{5};
        List<String> actualTrace = new ArrayList<>();
        quickSort.sort(input, actualTrace);
        List<String> expected = List.of("Q1", "Q2", "Q10");
        assertEquals(expected, actualTrace);
        assertSort(input);
    }

    @Test
    void qstraceAlreadySortedTest() {
        int[] input = new int[]{1, 2};
        List<String> actualTrace = new ArrayList<>();
        quickSort.sort(input, actualTrace);
        List<String> expected = List.of("Q1", "Q2", "Q3", "Q4", "Q6", "Q10");
        assertEquals(expected, actualTrace);
        assertSort(input);
    }

    @Test
    void qstraceOneSwapSortTest() {
        int[] input = new int[]{2, 1};
        List<String> actualTrace = new ArrayList<>();
        quickSort.sort(input, actualTrace);
        List<String> expected = List.of("Q1", "Q2", "Q3", "Q4", "Q7", "Q10");
        assertEquals(expected, actualTrace);
        assertSort(input);
    }

    @Test
    void qstraceNormSortTest() {
        int[] input = new int[]{4, 1, 3, 2, 5};
        List<String> actualTrace = new ArrayList<>();
        quickSort.sort(input, actualTrace);
        List<String> expected = List.of(
                "Q1", "Q2", "Q3", "Q4", "Q6", "Q7", "Q5", "Q8",
                "Q1", "Q2", "Q3", "Q4", "Q7", "Q10",
                "Q9",
                "Q1", "Q2", "Q3", "Q4", "Q6", "Q10",
                "Q10"
        );
        assertEquals(expected, actualTrace);
        assertSort(input);
    }

    @Test
    void qstraceDupSortTest() {
        int[] input = new int[]{2, 2, 1};
        List<String> actualTrace = new ArrayList<>();
        quickSort.sort(input, actualTrace);
        List<String> expected = List.of("Q1", "Q2", "Q3", "Q4", "Q7", "Q10");
        assertEquals(expected, actualTrace);
        assertSort(input);
    }


    private void assertSort(int[] actualSorted) {
        int[] expected = actualSorted.clone();
        Arrays.sort(expected);
        assertTrue(Arrays.equals(expected, actualSorted), "Array must be sorted correctly");
    }
}
