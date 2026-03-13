package lab1.quicksort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class QuickSortTraceTest {

    private final QuickSort quickSort = new QuickSort();

    @Test
    void traceForBaseCaseSingleElement() {
        // [5] -> immediate base case in quickSort(0, 0): Q1, Q2, Q10.
        int[] input = new int[]{5};
        List<String> actual = traceFor(input);
        List<String> expected = List.of("Q1", "Q2", "Q10");
        assertEquals(expected, actual);
        assertSortedLikeJdk(input);
    }

    @Test
    void traceForCaseWithoutActualSwap() {
        // [1, 2], pivot = 1. j is moved left once (Q6), i==j afterwards,
        // so there is no real swap event Q7.
        int[] input = new int[]{1, 2};
        List<String> actual = traceFor(input);
        List<String> expected = List.of("Q1", "Q2", "Q3", "Q4", "Q6", "Q10");
        assertEquals(expected, actual);
        assertSortedLikeJdk(input);
    }

    @Test
    void traceForCaseWithSwap() {
        // [2, 1], pivot = 2. First partition step swaps positions 0 and 1.
        int[] input = new int[]{2, 1};
        List<String> actual = traceFor(input);
        List<String> expected = List.of("Q1", "Q2", "Q3", "Q4", "Q7", "Q10");
        assertEquals(expected, actual);
        assertSortedLikeJdk(input);
    }

    @Test
    void traceForRecursionIntoBothSides() {
        // [4,1,3,2,5] with pivot 3:
        // - first partition has j move (Q6), swap (Q7), then i move (Q5)
        // - recursion enters left part (Q8) and right part (Q9)
        int[] input = new int[]{4, 1, 3, 2, 5};
        List<String> actual = traceFor(input);
        List<String> expected = List.of(
                "Q1", "Q2", "Q3", "Q4", "Q6", "Q7", "Q5", "Q8",
                "Q1", "Q2", "Q3", "Q4", "Q7", "Q10",
                "Q9",
                "Q1", "Q2", "Q3", "Q4", "Q6", "Q10",
                "Q10"
        );
        assertEquals(expected, actual);
        assertSortedLikeJdk(input);
    }

    @Test
    void traceForDuplicates() {
        // [2,2,1], pivot = middle element (2).
        // Equal elements do not trigger Q5/Q6 moves, but one swap is performed.
        int[] input = new int[]{2, 2, 1};
        List<String> actual = traceFor(input);
        List<String> expected = List.of("Q1", "Q2", "Q3", "Q4", "Q7", "Q10");
        assertEquals(expected, actual);
        assertSortedLikeJdk(input);
    }

    private List<String> traceFor(int[] input) {
        List<String> trace = new ArrayList<>();
        quickSort.sort(input, trace);
        return trace;
    }

    private void assertSortedLikeJdk(int[] actualSorted) {
        int[] expected = actualSorted.clone();
        Arrays.sort(expected);
        assertTrue(Arrays.equals(expected, actualSorted), "Array must be sorted correctly");
    }
}
