package biz.blocc.math.statistic;

public class ArithmeticMean {

    public static StatisticResult calculate(double[] data) {
        final StatisticResult statisticResult = new StatisticResult();

        double sum = 0.0;
        for (double aData : data) {
            sum += aData;
        }
        statisticResult.setMean(sum / data.length);

        return statisticResult;
    }

    public static StatisticResult calculateWithStdDev(double[] data) {
        final StatisticResult statisticResult = new StatisticResult();

        double sum = 0.0;
        for (double aData : data) {
            sum += aData;
        }
        final double mean = sum / data.length;
        statisticResult.setMean(mean);

        sum = 0.0;
        for (double aData : data) {
            final double delta = aData - mean;
            sum += delta * delta;
        }

        final double variance = sum / data.length;
        statisticResult.setStandardDeviation(Math.sqrt(variance));
        return statisticResult;
    }
}
