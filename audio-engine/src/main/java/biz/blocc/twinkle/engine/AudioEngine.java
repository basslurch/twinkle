package biz.blocc.twinkle.engine;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;

public class AudioEngine {

    public void initialize() {
        final AudioFileFormat.Type[] audioFileTypes = AudioSystem.getAudioFileTypes();
        for (AudioFileFormat.Type audioFileType : audioFileTypes) {
            System.out.println("audioFileType.getExtension() = " + audioFileType.getExtension());
        }
        System.out.println();

        final Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
        for (Mixer.Info mixerInfo : mixerInfos) {
            System.out.println("mixerInfo = " + mixerInfo.getDescription());
            System.out.println("mixerInfo = " + mixerInfo.getName());
            System.out.println("mixerInfo = " + mixerInfo.getVendor());
            System.out.println("mixerInfo = " + mixerInfo.getVersion());
            System.out.println();
        }


    }
}
