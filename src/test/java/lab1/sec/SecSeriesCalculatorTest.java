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
    void secZeroTest() {
        double result = calculator.sec(0.0, NORMAL_EPS);
        assertEquals(1.0, result, STRICT_DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.001, 0.01, -0.001, -0.01})
    void secSmallTest(double x) {
        double expected = 1.0 / Math.cos(x);
        double actual = calculator.sec(x, NORMAL_EPS);
        assertEquals(expected, actual, STRICT_DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.8, -0.5, -0.3, -0.2, 0.2, 0.3, 0.5, 0.8, 1.0})
    void secNormTest(double x) {
        double expected = 1.0 / Math.cos(x);
        double actual = calculator.sec(x, NORMAL_EPS);
        assertEquals(expected, actual, STRICT_DELTA);
    }

    @Test
    void secCloseLimTest() {
        double x = SecSeriesCalculator.SEC_LIMIT - 1.0e-6;
        double expected = 1.0 / Math.cos(x);
        double actual = calculator.sec(x, NORMAL_EPS);
        assertEquals(expected, actual, STRICT_DELTA);
    }

    @Test
    void secLimTest() {
        double x = SecSeriesCalculator.SEC_LIMIT;
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
    void secPorogTest(double x, double eps, double allowedDelta) {
        double expected = 1.0 / Math.cos(x);
        double actual = calculator.sec(x, eps);
        assertEquals(expected, actual, allowedDelta);
    }

    @Test
    void secSmallEmpsTest() {
        double x = 0.9;
        double positive = calculator.sec(x, VERY_SMALL_EPS);
        double negative = calculator.sec(-x, VERY_SMALL_EPS);
        assertEquals(positive, negative, STRICT_DELTA);
    }

    @Test
    void rejectsZeroEpsTest() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(0.1, 0.0));
    }

    @Test
    void rejectsNegativeEpsTest() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(0.1, -1.0e-6));
    }

    @Test
    void rejectsNanXTest() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(Double.NaN, NORMAL_EPS));
    }

    @Test
    void rejectsInfiniteXTest() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(Double.POSITIVE_INFINITY, NORMAL_EPS));
    }

    @Test
    void rejectsPiIsBigTest() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(Math.PI / 2.0, NORMAL_EPS));
    }

    @Test
    void rejectsValueCloseLimButNotInTest() {
        double outside = SecSeriesCalculator.SEC_LIMIT + 1.0e-9;
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(outside, NORMAL_EPS));
    }

    @Test
    void rejectsNanEpsTest() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(0.2, Double.NaN));
    }

    @Test
    void rejectsInfiniteEpsTest() {
        assertThrows(IllegalArgumentException.class, () -> calculator.sec(0.2, Double.POSITIVE_INFINITY));
    }
}
