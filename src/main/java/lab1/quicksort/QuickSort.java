package lab1.quicksort;

import java.util.List;


public class QuickSort {

    public void sort(int[] array) {
        sort(array, null);
    }

    public void sort(int[] array, List<String> trace) {
        if (array == null) {
            throw new IllegalArgumentException("массив не пустой");
        }
        quickSort(array, 0, array.length - 1, trace);
    }

    private void quickSort(int[] array, int left, int right, List<String> trace) {
        QSTracer.add(trace, QSTracer.Q1);
        QSTracer.add(trace, QSTracer.Q2);

        if (left >= right) {
            QSTracer.add(trace, QSTracer.Q10);
            return;
        }

        int i = left;
        int j = right;
        int pivot = array[(right + left) / 2];
        QSTracer.add(trace, QSTracer.Q3);
        QSTracer.add(trace, QSTracer.Q4);

        while (i <= j) {
            while (array[i] < pivot) {
                QSTracer.add(trace, QSTracer.Q5);
                i++;
            }
            while (array[j] > pivot) {
                QSTracer.add(trace, QSTracer.Q6);
                j--;
            }
            if (i <= j) {
                if (i < j) {
                    QSTracer.add(trace, QSTracer.Q7);
                    swap(array, i, j);
                }
                i++;
                j--;
            }
        }

        if (left < j) {
            QSTracer.add(trace, QSTracer.Q8);
            quickSort(array, left, j, trace);
        }
        if (i < right) {
            QSTracer.add(trace, QSTracer.Q9);
            quickSort(array, i, right, trace);
        }

        QSTracer.add(trace, QSTracer.Q10);
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
