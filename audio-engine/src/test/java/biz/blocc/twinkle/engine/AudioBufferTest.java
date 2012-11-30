package biz.blocc.twinkle.engine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AudioBufferTest {

    private AudioBuffer audioBuffer;

    @BeforeMethod
    public void setUp() {
        audioBuffer = new AudioBuffer();
    }

    @Test
    public void testDefaultConstruction() {
        assertEquals(audioBuffer.getNumChannels(), 2);
        assertEquals(audioBuffer.getLength(), 512);
    }

    @Test
    public void testSetGetNumChannels() {
        audioBuffer.setNumChannels(1);
        assertEquals(audioBuffer.getNumChannels(), 1);

        audioBuffer.setNumChannels(3);
        assertEquals(audioBuffer.getNumChannels(), 3);
    }

    @Test
    public void testSetGetLength() {
        audioBuffer.setLength(768);
        assertEquals(audioBuffer.getLength(), 768);

        audioBuffer.setLength(2048);
        assertEquals(audioBuffer.getLength(), 2048);
    }

    @Test
    public void testGetData() {
        final double[][] data = audioBuffer.getData();
        assertNotNull(data);
        assertEquals(data.length, 2);
        assertEquals(data[0].length, 512);
        assertEquals(data[1].length, 512);
    }

    @Test
    public void testGetDataReturnsSameBuffer() {
        final double[][] data_1 = audioBuffer.getData();
        final double[][] data_2 = audioBuffer.getData();

        assertSame(data_1, data_2);
    }

    @Test
    public void testBufferLengthAdaptsWhenLengthIsSet() {
        audioBuffer.setLength(128);

        double[][] data = audioBuffer.getData();
        assertEquals(data.length, 2);
        assertEquals(data[0].length, 128);
        assertEquals(data[1].length, 128);
    }

    @Test
    public void testBufferIsNotChangedWhenLengthIsSetWithCurrentValue() {
        double[][] data_before = audioBuffer.getData();

        audioBuffer.setLength(512);

        double[][] data_after = audioBuffer.getData();

        assertEquals(data_after.length, 2);
        assertEquals(data_after[0].length, 512);
        assertEquals(data_after[1].length, 512);

        assertSame(data_before, data_after);
        assertSame(data_before[0], data_after[0]);
        assertSame(data_before[1], data_after[1]);
    }

    @Test
    public void testBufferChannelsAdaptWhenNumChannelsSet() {
        audioBuffer.setNumChannels(3);

        double[][] data = audioBuffer.getData();
        assertEquals(data.length, 3);
        assertEquals(data[0].length, 512);
        assertEquals(data[1].length, 512);
        assertEquals(data[2].length, 512);
    }

    @Test
    public void testBufferChannelsAreNotCHangedWhenNumChannelsIsSetWithCurrentValue() {
        double[][] data_before = audioBuffer.getData();

        audioBuffer.setNumChannels(2);

        double[][] data_after = audioBuffer.getData();

        assertEquals(data_after.length, 2);
        assertEquals(data_after[0].length, 512);
        assertEquals(data_after[1].length, 512);

        assertSame(data_before, data_after);
        assertSame(data_before[0], data_after[0]);
        assertSame(data_before[1], data_after[1]);
    }
}
