package biz.blocc.twinkle.engine;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;

class JavaSoundAPI implements SoundAPI {

     public Mixer.Info[] getMixerInfo() {
        return AudioSystem.getMixerInfo();
    }
}
