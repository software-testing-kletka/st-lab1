package lab1.quicksort;

import java.util.List;

/**
 * Quicksort implementation for int[] with optional execution tracing.
 */
public class QuickSort {

    /**
     * Sorts array in ascending order.
     *
     * @param array array to sort
     */
    public void sort(int[] array) {
        sort(array, null);
    }

    /**
     * Sorts array in ascending order and appends visited characteristic points
     * to {@code trace} when it is not null.
     *
     * @param array array to sort
     * @param trace trace sink for points Q1..Q10
     */
    public void sort(int[] array, List<String> trace) {
        if (array == null) {
            throw new IllegalArgumentException("array must not be null");
        }
        quickSort(array, 0, array.length - 1, trace);
    }

    private void quickSort(int[] array, int left, int right, List<String> trace) {
        QuickSortTracer.add(trace, QuickSortTracer.Q1);
        QuickSortTracer.add(trace, QuickSortTracer.Q2);

        if (left >= right) {
            QuickSortTracer.add(trace, QuickSortTracer.Q10);
            return;
        }

        int i = left;
        int j = right;
        int pivot = array[left + (right - left) / 2];
        QuickSortTracer.add(trace, QuickSortTracer.Q3);
        QuickSortTracer.add(trace, QuickSortTracer.Q4);

        while (i <= j) {
            while (array[i] < pivot) {
                QuickSortTracer.add(trace, QuickSortTracer.Q5);
                i++;
            }
            while (array[j] > pivot) {
                QuickSortTracer.add(trace, QuickSortTracer.Q6);
                j--;
            }
            if (i <= j) {
                if (i < j) {
                    QuickSortTracer.add(trace, QuickSortTracer.Q7);
                    swap(array, i, j);
                }
                i++;
                j--;
            }
        }

        if (left < j) {
            QuickSortTracer.add(trace, QuickSortTracer.Q8);
            quickSort(array, left, j, trace);
        }
        if (i < right) {
            QuickSortTracer.add(trace, QuickSortTracer.Q9);
            quickSort(array, i, right, trace);
        }

        QuickSortTracer.add(trace, QuickSortTracer.Q10);
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
