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
}
