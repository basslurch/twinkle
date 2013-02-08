package biz.blocc.twinkle.engine.source;

import biz.blocc.math.statistic.ArithmeticMean;
import biz.blocc.math.statistic.StatisticResult;
import biz.blocc.twinkle.engine.AudioBuffer;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class WhiteNoiseSourceTest {

    @Test
    public void testProcessMono() {
        final WhiteNoiseSource source = new WhiteNoiseSource();
        final AudioBuffer sourceBuffer = new AudioBuffer();
        sourceBuffer.setLength(275);
        sourceBuffer.setNumChannels(1);

        final double[][] sourceBufferData = sourceBuffer.getData();
        final double[] samples = sourceBufferData[0];
        for (int i = 0; i < samples.length; i++) {
            samples[i] = 1.0;
        }

        final AudioBuffer processedBuffer = source.process(sourceBuffer);
        assertNotNull(processedBuffer);
        final StatisticResult statisticResult = ArithmeticMean.calculateWithStdDev(processedBuffer.getData()[0]);
        assertTrue(Math.abs(statisticResult.getMean()) < 0.1);
        assertTrue(Math.abs(statisticResult.getStandardDeviation()) > 0.5);
    }
}
