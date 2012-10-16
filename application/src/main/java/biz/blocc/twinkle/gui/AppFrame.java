package biz.blocc.twinkle.gui;

import javax.swing.*;

public class AppFrame {

    public static AppFrame create() {
        return new AppFrame(new JFrame());
    }

    public void show() {
        frame.setVisible(true);
    }

    //---------------------------------------------------------------------------
    //----- End of public -------------------------------------------------------
    //---------------------------------------------------------------------------

    private JFrame frame;

    AppFrame(JFrame frame) {
        this.frame = frame;
        init(this.frame);
    }

    void init(JFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationByPlatform(true);
        frame.setTitle("Twinkle");
    }
}
