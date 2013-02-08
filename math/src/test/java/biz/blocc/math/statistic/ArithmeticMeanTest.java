package biz.blocc.math.statistic;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArithmeticMeanTest {

    @Test
    public void testCalculate_zeroData() {
        final double[] buffer = new double[23];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = 0.0;
        }

        final StatisticResult result = ArithmeticMean.calculate(buffer);
        assertEquals(result.getMean(), 0.0, 1e-8);
    }

    @Test
    public void testCalculate_constantData() {
        final double[] buffer = new double[16];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = 1.0;
        }

        final StatisticResult result = ArithmeticMean.calculate(buffer);
        assertEquals(result.getMean(), 1.0, 1e-8);
    }

    @Test
    public void testCalculate_alternatingData() {
        final double[] buffer = new double[24];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = i % 2 == 0 ? 1.0 : -1.0;
        }

        final StatisticResult result = ArithmeticMean.calculate(buffer);
        assertEquals(result.getMean(), 0.0, 1e-8);
    }

    @Test
    public void testCalculate_alternatingData_withOffset() {
        final double[] buffer = new double[28];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = i % 2 == 0 ? 1.0 : -1.0;
            buffer[i] += 0.23;
        }

        final StatisticResult result = ArithmeticMean.calculate(buffer);
        assertEquals(result.getMean(), 0.23, 1e-8);
    }

    @Test
    public void testCalculateWithStdDev_zeroData() {
        final double[] buffer = new double[29];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = 0.0;
        }

        final StatisticResult result = ArithmeticMean.calculateWithStdDev(buffer);
        assertEquals(result.getMean(), 0.0, 1e-8);
        assertEquals(result.getStandardDeviation(), 0.0, 1e-8);
    }

    @Test
    public void testCalculateWithStdDev_constantData() {
        final double[] buffer = new double[16];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = -0.2;
        }

        final StatisticResult result = ArithmeticMean.calculateWithStdDev(buffer);
        assertEquals(result.getMean(), -0.2, 1e-8);
        assertEquals(result.getStandardDeviation(), 0.0, 1e-8);
    }

    @Test
    public void testCalculateWithStdDev_alternatingData() {
        final double[] buffer = new double[32];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = i % 2 == 0 ? 1.0 : -1.0;
        }

        final StatisticResult result = ArithmeticMean.calculateWithStdDev(buffer);
        assertEquals(result.getMean(), 0.0, 1e-8);
        assertEquals(result.getStandardDeviation(), 1.0, 1e-8);
    }

    @Test
    public void testCalculateWithStdDev_alternatingData_withOffset() {
        final double[] buffer = new double[48];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = i % 2 == 0 ? 1.0 : -1.0;
            buffer[i] += 0.17;
        }

        final StatisticResult result = ArithmeticMean.calculateWithStdDev(buffer);
        assertEquals(result.getMean(), 0.17, 1e-8);
        assertEquals(result.getStandardDeviation(), 1.0, 1e-8);
    }
}
