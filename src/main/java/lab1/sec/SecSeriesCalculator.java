package lab1.sec;

import java.util.ArrayList;
import java.util.List;


public class SecSeriesCalculator {

    public static final double SEC_LIMIT = Math.PI / 3.0;
    private static final int MAX_ITERS = 200;


    public double sec(double x, double eps) {
        validateInput(x, eps);

        List<Double> eulerValNumbers = new ArrayList<>();
        eulerValNumbers.add(1.0);

        double sum = 1.0;
        double xPower = 1.0;

        int n = 0;
        while (true) {
            n++;
            if (n > MAX_ITERS) {
                throw new IllegalStateException(
                        "Series did not converge within " + MAX_ITERS + " terms."
                );
            }

            double eulerVal = nextEulerVal(n, eulerValNumbers);
            eulerValNumbers.add(eulerVal);

            xPower = xPower * x * x;

            double sign = (n % 2 == 0) ? 1.0 : -1.0;
            double nextTerm = sign * eulerVal * xPower / fact(2*n);

            if (Math.abs(nextTerm) < eps) {
                break;
            }
            sum += nextTerm;
        }

        return sum;
    }

    private void validateInput(double x, double eps) {
        if (!Double.isFinite(eps) || eps <= 0.0) {
            throw new IllegalArgumentException("эпсилон > 0 и конечный");
        }
        if (!Double.isFinite(x)) {
            throw new IllegalArgumentException("x конечный");
        }
        if (Math.abs(x) > SEC_LIMIT) {
            throw new IllegalArgumentException(
                    "для лучшей сходимости: |x| <= " + SEC_LIMIT
            );
        }
    }

    private double nextEulerVal(int n, List<Double> eulerList) {
        int twoN = 2 * n;
        double sum = 0.0;
        for (int k = 0; k < n; k++) {
            int twoK = 2 * k;
            sum += binomial(twoN, twoK) * eulerList.get(k);
        }
        return -sum;
    }

    private double binomial(int n, int k) {

        if (k < 0 || k > n) {
            return 0.0;
        }

        return fact(n) / (fact(k) * fact(n - k));
    }

    private double fact(int n) {
        double result = 1.0;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
