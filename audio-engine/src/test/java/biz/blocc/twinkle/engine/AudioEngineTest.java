package biz.blocc.twinkle.engine;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sound.sampled.Mixer;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class AudioEngineTest {

    private AudioEngine audioEngine;

    @BeforeMethod
    public void setUp() {
        audioEngine = new AudioEngine();
    }

    @Test
    public void testCreate() {
        final AudioEngine engine = AudioEngine.create();
        assertNotNull(engine);
    }

    @Test
    public void testInitialize_withNoMixers() {
        audioEngine.initialize(new MockSoundAPI());

        final IODevice[] ioDevices = audioEngine.getDevices();
        assertEquals(ioDevices.length, 0);

        final Mixer.Info[] mixers = audioEngine.getMixers();
        assertEquals(mixers.length, 0);
    }

    @Test
    public void testInitialize_withOneMixer() {
        final MockSoundAPI soundAPI = new MockSoundAPI();
        final String expectedName = "name";
        soundAPI.add(new MockMixerInfo(expectedName, "vendor", "description", "version"));

        audioEngine.initialize(soundAPI);

        final IODevice[] ioDevices = audioEngine.getDevices();
        assertEquals(ioDevices.length, 1);
        assertEquals(ioDevices[0].getName(), expectedName);

        final Mixer.Info[] mixers = audioEngine.getMixers();
        assertEquals(mixers.length, 1);
        assertEquals(mixers[0].getName(), expectedName);
    }

    @Test
    public void testInitialize_withTwoMixers() {
        final MockSoundAPI soundAPI = new MockSoundAPI();
        final String expectedName_1 = "name";
        final String expectedName_2 = "nameTwo";

        soundAPI.add(new MockMixerInfo(expectedName_1, "vendor", "description", "version"));
        soundAPI.add(new MockMixerInfo(expectedName_2, "vendor", "description", "version"));

        audioEngine.initialize(soundAPI);

        final IODevice[] ioDevices = audioEngine.getDevices();
        assertEquals(ioDevices.length, 2);
        assertEquals(ioDevices[0].getName(), expectedName_1);
        assertEquals(ioDevices[1].getName(), expectedName_2);

        final Mixer.Info[] mixers = audioEngine.getMixers();
        assertEquals(mixers.length, 2);
        assertEquals(mixers[0].getName(), expectedName_1);
        assertEquals(mixers[1].getName(), expectedName_2);
    }
}
