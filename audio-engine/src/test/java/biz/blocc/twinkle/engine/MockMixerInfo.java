package biz.blocc.twinkle.engine;

import javax.sound.sampled.Mixer;

class MockMixerInfo extends Mixer.Info {

    MockMixerInfo(String name, String vendor, String description, String version) {
        super(name, vendor, description, version);
    }
}

