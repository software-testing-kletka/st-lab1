package lab1.quicksort;

import java.util.List;

/**
 * Utility for recording characteristic points of quicksort execution.
 */
public final class QuickSortTracer {

    public static final String Q1 = "Q1";   // enter quickSort(left, right)
    public static final String Q2 = "Q2";   // base-case check / subarray validity
    public static final String Q3 = "Q3";   // pivot selection
    public static final String Q4 = "Q4";   // enter partition loop
    public static final String Q5 = "Q5";   // move i right
    public static final String Q6 = "Q6";   // move j left
    public static final String Q7 = "Q7";   // swap elements
    public static final String Q8 = "Q8";   // recurse left
    public static final String Q9 = "Q9";   // recurse right
    public static final String Q10 = "Q10"; // exit quickSort

    private QuickSortTracer() {
    }

    public static void add(List<String> trace, String point) {
        if (trace != null) {
            trace.add(point);
        }
    }
}
