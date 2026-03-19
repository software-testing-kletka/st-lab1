package lab1.quicksort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class QuickSortTest {

    private final QuickSort quickSort = new QuickSort();

    @Test
    void qsEmptyTest() {
        assertMySortedAndNormSort(new int[]{});
    }

    @Test
    void qsSingleElementTest() {
        assertMySortedAndNormSort(new int[]{42});
    }

    @Test
    void qsAlreadySortedTest() {
        assertMySortedAndNormSort(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    void qsEeverseTest() {
        assertMySortedAndNormSort(new int[]{5, 4, 3, 2, 1});
    }

    @Test
    void qsNormTest() {
        assertMySortedAndNormSort(new int[]{7, 1, 9, 3, 8, 2, 6, 5, 4});
    }

    @Test
    void qsDupSortTest() {
        assertMySortedAndNormSort(new int[]{3, 1, 2, 3, 2, 1, 3, 2});
    }

    @Test
    void qsEqualElementsTest() {
        assertMySortedAndNormSort(new int[]{5, 5, 5, 5, 5, 5});
    }

    @Test
    void qsNegativeValTest() {
        assertMySortedAndNormSort(new int[]{0, -10, 4, -3, 8, -1, 2, 7, -5});
    }

    @Test
    void throwsForNullArray() {
        assertThrows(IllegalArgumentException.class, () -> quickSort.sort(null));
    }

    private void assertMySortedAndNormSort(int[] input) {
        int[] actual = Arrays.copyOf(input, input.length);
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);

        quickSort.sort(actual);

        assertArrayEquals(expected, actual, "Sorted array must match expected order");
        assertTrue(isSorted(actual), "Array must be sorted in ascending order");
    }

    private boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
