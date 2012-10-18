package biz.blocc.twinkle.application;

import biz.blocc.twinkle.engine.AudioEngine;
import biz.blocc.twinkle.gui.AppFrame;

public class TwinkleApplication {

    public static void main(String[] args) {
        final TwinkleApplication application = new TwinkleApplication();
        application.start();
    }

    public void exitApplication() {
        System.exit(0);
    }

    ////////////////////////////////////////////////////////////////////////////////
    /////// END OF PUBLIC
    ////////////////////////////////////////////////////////////////////////////////

    private void start() {
        final AudioEngine audioEngine = AudioEngine.create();

        final AppFrame appFrame = AppFrame.create(this);
        appFrame.show();
    }
}
