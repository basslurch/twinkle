package biz.blocc.twinkle.application;

import biz.blocc.twinkle.engine.AudioEngine;
import biz.blocc.twinkle.gui.AppFrame;

public class TwinkleApplication {

    public static void main(String[] args) {

        final AudioEngine audioEngine = new AudioEngine();
        audioEngine.initialize();

        final AppFrame appFrame = AppFrame.create();
        appFrame.show();
    }
}
