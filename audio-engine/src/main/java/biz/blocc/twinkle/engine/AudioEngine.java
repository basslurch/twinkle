package biz.blocc.twinkle.engine;

import javax.sound.sampled.Mixer;
import java.util.Collection;
import java.util.HashMap;

public class AudioEngine {

    public static AudioEngine create() {
        final AudioEngine audioEngine = new AudioEngine();
        audioEngine.initialize(new JavaSoundAPI());
        return audioEngine;
    }

    public IODevice[] getDevices() {
        final Collection<IODevice> deviceCollection = ioDevices.values();
        return deviceCollection.toArray(new IODevice[deviceCollection.size()]);
    }

    ////////////////////////////////////////////////////////////////////////////////
    /////// END OF PUBLIC
    ////////////////////////////////////////////////////////////////////////////////

    private HashMap<String, IODevice> ioDevices;
    private HashMap<String, Mixer.Info> ioMixers;

    AudioEngine() {
        ioDevices = new HashMap<String, IODevice>();
        ioMixers = new HashMap<String, Mixer.Info>();
    }

    void initialize(SoundAPI soundAPI) {
        final Mixer.Info[] mixerInfos = soundAPI.getMixerInfo();
        for (Mixer.Info mixerInfo : mixerInfos) {
            final IODevice ioDevice = new IODevice();
            final String mixerInfoName = mixerInfo.getName();

            ioDevice.setName(mixerInfoName);

            ioDevices.put(mixerInfoName, ioDevice);
            ioMixers.put(mixerInfoName, mixerInfo);
        }
    }

    // for testing access only tb 2012.10.17
    Mixer.Info[] getMixers() {
        final Collection<Mixer.Info> values = ioMixers.values();
        return values.toArray(new Mixer.Info[values.size()]);
    }
}
