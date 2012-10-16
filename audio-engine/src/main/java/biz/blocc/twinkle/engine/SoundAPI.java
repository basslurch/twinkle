package biz.blocc.twinkle.engine;

import javax.sound.sampled.Mixer;

interface SoundAPI {

    public Mixer.Info[] getMixerInfo();

    public Mixer getMixer(Mixer.Info info);
}
