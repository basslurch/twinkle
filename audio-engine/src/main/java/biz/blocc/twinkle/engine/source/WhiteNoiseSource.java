package biz.blocc.twinkle.engine.source;

import biz.blocc.twinkle.engine.AudioBuffer;

import java.util.Date;
import java.util.Random;

public class WhiteNoiseSource {

    public AudioBuffer process(AudioBuffer sourceBuffer) {
        final Date date = new Date();
        final Random random = new Random(date.getTime());

        final double[][] data = sourceBuffer.getData();
        for (int i = 0; i < sourceBuffer.getNumChannels(); i++) {
            final double[] samples = data[i];
            for (int j = 0; j < samples.length; j++) {
                samples[j] = 2.0 * random.nextDouble() - 1.0;
            }
        }

        return sourceBuffer;
    }
}
