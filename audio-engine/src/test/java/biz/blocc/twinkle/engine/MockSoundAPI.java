package biz.blocc.twinkle.engine;

import javax.sound.sampled.Mixer;
import java.util.ArrayList;

class MockSoundAPI implements SoundAPI {

    public Mixer.Info[] getMixerInfo() {
        return mixers.toArray(new Mixer.Info[mixers.size()]);
    }

    ////////////////////////////////////////////////////////////////////////////////
    /////// END OF PUBLIC
    ////////////////////////////////////////////////////////////////////////////////

    MockSoundAPI() {
        mixers = new ArrayList<Mixer.Info>();
    }

    void add(Mixer.Info mixerInfo) {
        mixers.add(mixerInfo);
    }

    private ArrayList<Mixer.Info> mixers;
}
