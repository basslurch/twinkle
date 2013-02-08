package biz.blocc.math.statistic;

public class StatisticResult {
    private double mean;
    private double standardDeviation;

    public StatisticResult() {
        mean = Double.NaN;
        standardDeviation = Double.NaN;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getMean() {
        return mean;
    }

    public void setStandardDeviation(double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }
}
