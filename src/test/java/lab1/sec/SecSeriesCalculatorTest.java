package lab1.sec;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SecSeriesCalculatorTest {

    private static final double NORMAL_EPS = 1.0e-12;
    private static final double VERY_SMALL_EPS = 1.0e-14;
    private static final double STRICT_DELTA = 1.0e-10;
    private final SecSeriesCalculator calculator = new SecSeriesCalculator();

    @Test
    void secAtZeroIsOne() {
        double result = calculator.sec(0.0, NORMAL_EPS);
        assertEquals(1.0, result, STRICT_DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.001, 0.01, -0.001, -0.01})
    void secForSmallArgumentsMatchesReference(double x) {
        double expected = 1.0 / Math.cos(x);
        double actual = calculator.sec(x, NORMAL_EPS);
        assertEquals(expected, actual, STRICT_DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.8, -0.5, -0.2, 0.2, 0.5, 0.8, 1.0})
    void secInsideWorkingDomainMatchesReference(double x) {
        double expected = 1.0 / Math.cos(x);
        double actual = calculator.sec(x, NORMAL_EPS);
        assertEquals(expected, actual, STRICT_DELTA);
    }

    @Test
    void secNearDomainBoundaryStillAccurate() {
        double x = SecSeriesCalculator.MAX_SUPPORTED_ABS_X - 1.0e-6;
        double expected = 1.0 / Math.cos(x);
        double actual = calculator.sec(x, NORMAL_EPS);
        assertEquals(expected, actual, STRICT_DELTA);
    }

    @Test
    void secAtExactDomainBoundaryIsAccurate() {
        double x = SecSeriesCalculator.MAX_SUPPORTED_ABS_X;
        double expected = 1.0 / Math.cos(x);
        double actual = calculator.sec(x, NORMAL_EPS);
        assertEquals(expected, actual, STRICT_DELTA);
    }

    @ParameterizedTest
    @CsvSource({
            "0.7, 1.0E-14, 1.0E-11",
            "0.7, 1.0E-8, 1.0E-6",
            "0.7, 1.0E-3, 3.0E-3"
    })
    void secSupportsDifferentPrecisionThresholds(double x, double eps, double allowedDelta) {
        // allowedDelta is scaled with eps to reflect expected truncation accuracy.
        double expected = 1.0 / Math.cos(x);
        double actual = calculator.sec(x, eps);
        assertEquals(expected, actual, allowedDelta);
    }

    @Test
    void secIsEvenFunctionWithinTolerance() {
        double x = 0.9;
        double positive = calculator.sec(x, VERY_SMALL_EPS);
        double negative = calculator.sec(-x, VERY_SMALL_EPS);
        assertEquals(positive, negative, STRICT_DELTA);
    }

    @Test
    void rejectsZeroEps() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(0.1, 0.0));
    }

    @Test
    void rejectsNegativeEps() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(0.1, -1.0e-6));
    }

    @Test
    void rejectsNanX() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(Double.NaN, NORMAL_EPS));
    }

    @Test
    void rejectsInfiniteX() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(Double.POSITIVE_INFINITY, NORMAL_EPS));
    }

    @Test
    void rejectsPiOverTwoBecauseItIsOutsideConfiguredDomain() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(Math.PI / 2.0, NORMAL_EPS));
    }

    @Test
    void rejectsValueTooCloseToConfiguredBoundary() {
        double outside = SecSeriesCalculator.MAX_SUPPORTED_ABS_X + 1.0e-9;
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(outside, NORMAL_EPS));
    }

    @Test
    void rejectsNanEps() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(0.2, Double.NaN));
    }

    @Test
    void rejectsInfiniteEps() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(0.2, Double.POSITIVE_INFINITY));
    }
}
