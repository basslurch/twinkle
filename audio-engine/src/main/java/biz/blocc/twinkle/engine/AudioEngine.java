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

    AudioEngine() {
        ioDevices = new HashMap<String, IODevice>();
    }

    void initialize(SoundAPI soundAPI) {
        final Mixer.Info[] mixerInfos = soundAPI.getMixerInfo();
        for (Mixer.Info mixerInfo : mixerInfos) {
            final IODevice ioDevice = new IODevice();
            final String mixerInfoName = mixerInfo.getName();

            ioDevice.setName(mixerInfoName);
            ioDevices.put(mixerInfoName, ioDevice);
        }
    }
}
