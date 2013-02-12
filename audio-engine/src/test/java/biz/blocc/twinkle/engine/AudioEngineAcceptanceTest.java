package biz.blocc.twinkle.engine;

import org.testng.annotations.Test;

import javax.sound.sampled.Mixer;
import java.net.UnknownHostException;

public class AudioEngineAcceptanceTest {

    @Test
    public void testGetMixerInfos() throws UnknownHostException {
        final JavaSoundAPI api = new JavaSoundAPI();
        final Mixer.Info[] mixerInfo = api.getMixerInfo();
        for (final Mixer.Info info : mixerInfo) {
//            System.out.println("info.getName() = " + info.getName());
//            System.out.println("info.getDescri = " + info.getDescription());
//            System.out.println("info.getVendor = " + info.getVendor());
//            System.out.println("info.getVersio = " + info.getVersion());
//            System.out.println();
        }
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
    }
}


