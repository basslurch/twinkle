package biz.blocc.math.statistic;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StatisticResultTest {

    private StatisticResult result;

    @BeforeMethod
    public void setUp() {
        result = new StatisticResult();
    }

    @Test
    public void testSetGetMean() {
        final double mean_1 = 3.8874;
        final double mean_2 = 0.23;

        result.setMean(mean_1);
        assertEquals(result.getMean(), mean_1, 1e-8);

        result.setMean(mean_2);
        assertEquals(result.getMean(), mean_2, 1e-8);
    }

    @Test
    public void testSetGetStandardDeviation() {
        final double stdDev_1 = 0.0034;
        final double stdDev_2 = 1.24;

        result.setStandardDeviation(stdDev_1);
        assertEquals(result.getStandardDeviation(), stdDev_1, 1e-8);

        result.setStandardDeviation(stdDev_2);
        assertEquals(result.getStandardDeviation(), stdDev_2, 1e-8);
    }
}
