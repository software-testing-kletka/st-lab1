package lab1.sec;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculator for sec(x) via Maclaurin series around zero.
 *
 * <p>Why domain is limited to |x| <= pi/3:
 * the series for sec(x) has nearest singularities at x = +/-pi/2, so formal
 * convergence radius is pi/2. For this lab we intentionally keep a safety
 * margin from singularities to get stable and fast convergence for a wide
 * range of eps values. With this domain restriction all singular points
 * x = pi/2 + k*pi are excluded by design.</p>
 */
public class SecSeriesCalculator {

    public static final double MAX_SUPPORTED_ABS_X = Math.PI / 3.0;
    private static final int MAX_SERIES_TERMS = 200;

    /**
     * Computes sec(x) with stopping rule |next term| < eps.
     * The first term that is already below eps is not added to the sum.
     */
    public double sec(double x, double eps) {
        validateInput(x, eps);

        List<Double> eulerEvenNumbers = new ArrayList<>();
        eulerEvenNumbers.add(1.0);

        double sum = 1.0;
        double xSquared = x * x;
        double xPower = 1.0;
        double factorial = 1.0;

        int n = 0;
        while (true) {
            n++;
            if (n > MAX_SERIES_TERMS) {
                throw new IllegalStateException(
                        "Series did not converge within " + MAX_SERIES_TERMS + " terms."
                );
            }

            double eulerEven = computeNextEulerEven(n, eulerEvenNumbers);
            eulerEvenNumbers.add(eulerEven);

            xPower *= xSquared;
            int twoN = 2 * n;
            factorial *= (twoN - 1) * (double) twoN;

            double sign = (n % 2 == 0) ? 1.0 : -1.0;
            double nextTerm = sign * eulerEven * xPower / factorial;
            if (Math.abs(nextTerm) < eps) {
                break;
            }
            sum += nextTerm;
        }

        return sum;
    }

    private void validateInput(double x, double eps) {
        if (!Double.isFinite(eps) || eps <= 0.0) {
            throw new IllegalArgumentException("eps must be finite and > 0.");
        }
        if (!Double.isFinite(x)) {
            throw new IllegalArgumentException("x must be finite.");
        }
        if (Math.abs(x) > MAX_SUPPORTED_ABS_X) {
            throw new IllegalArgumentException(
                    "x is outside supported domain: |x| <= " + MAX_SUPPORTED_ABS_X
            );
        }
    }

    /**
     * Recurrence for classical Euler numbers E(2n):
     * E(0) = 1,
     * E(2n) = -sum_{k=0..n-1} C(2n, 2k) * E(2k).
     */
    private double computeNextEulerEven(int n, List<Double> knownEulerEven) {
        int twoN = 2 * n;
        double sum = 0.0;
        for (int k = 0; k < n; k++) {
            int twoK = 2 * k;
            sum += binomial(twoN, twoK) * knownEulerEven.get(k);
        }
        return -sum;
    }

    private double binomial(int n, int k) {
        if (k < 0 || k > n) {
            return 0.0;
        }
        int effectiveK = Math.min(k, n - k);
        double result = 1.0;
        for (int i = 1; i <= effectiveK; i++) {
            result = result * (n - effectiveK + i) / i;
        }
        return result;
    }
}
