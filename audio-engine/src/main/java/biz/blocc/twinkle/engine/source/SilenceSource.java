package biz.blocc.twinkle.engine.source;


import biz.blocc.twinkle.engine.AudioBuffer;

public class SilenceSource {

    public AudioBuffer process(AudioBuffer audioBuffer) {
        final double[][] data = audioBuffer.getData();
        for (int i = 0; i < audioBuffer.getNumChannels(); i++) {
            final double[] samples = data[i];
            for (int j = 0; j < samples.length; j++) {
                samples[j] = 0.0;
            }
        }

        return audioBuffer;
    }
}
