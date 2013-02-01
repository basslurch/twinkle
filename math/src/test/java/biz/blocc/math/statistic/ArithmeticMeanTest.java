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
}
