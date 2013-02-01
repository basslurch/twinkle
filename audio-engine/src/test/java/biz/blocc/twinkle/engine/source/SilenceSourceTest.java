package biz.blocc.twinkle.engine.source;

import biz.blocc.twinkle.engine.AudioBuffer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class SilenceSourceTest {

    private SilenceSource silenceSource;

    @BeforeMethod
    public void setUp() {
        silenceSource = new SilenceSource();
    }

    @Test
    public void testProcess_mono() {
        final AudioBuffer source = new AudioBuffer();
        source.setNumChannels(1);

        final AudioBuffer processed = silenceSource.process(source);
        assertNotNull(processed);
        assertEquals(processed.getLength(), source.getLength());
        assertEquals(processed.getNumChannels(), source.getNumChannels());

        final double[][] data = processed.getData();
        assertChannelIsSilent(data[0]);
    }

    @Test
    public void testProcess_stereo() {
        final AudioBuffer source = new AudioBuffer();
        source.setNumChannels(2);
        source.setLength(185);

        final AudioBuffer processed = silenceSource.process(source);
        assertNotNull(processed);
        assertEquals(processed.getLength(), source.getLength());
        assertEquals(processed.getNumChannels(), source.getNumChannels());

        final double[][] data = processed.getData();
        assertChannelIsSilent(data[0]);
        assertChannelIsSilent(data[1]);
    }

    @Test
    public void testProcess_mono_overwrites() {
        final AudioBuffer source = new AudioBuffer();
        source.setNumChannels(1);
        fillWithData(source.getData()[0]);

        final AudioBuffer processed = silenceSource.process(source);
        final double[][] processedData = processed.getData();
        assertChannelIsSilent(processedData[0]);
    }

    @Test
    public void testProcess_stereo_overwrites() {
        final AudioBuffer source = new AudioBuffer();
        source.setNumChannels(2);
        source.setLength(213);
        final double[][] sourceData = source.getData();
        fillWithData(sourceData[0]);
        fillWithData(sourceData[1]);

        final AudioBuffer processed = silenceSource.process(source);

        final double[][] processedData = processed.getData();
        assertChannelIsSilent(processedData[0]);
        assertChannelIsSilent(processedData[1]);
    }

    private void fillWithData(double[] samples) {
        for (int i = 0; i < samples.length; i++) {
            samples[i] = i;
        }
    }

    private void assertChannelIsSilent(double[] monoBuffer) {
        for (double sample : monoBuffer) {
            assertEquals(sample, 0.0, 1e-8);
        }
    }
}
