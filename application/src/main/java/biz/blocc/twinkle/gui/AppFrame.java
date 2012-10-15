package biz.blocc.twinkle.gui;

import javax.swing.*;

public class AppFrame {

    private JFrame frame;

    public static AppFrame create() {
        return new AppFrame(new JFrame());
    }

    public AppFrame(JFrame frame) {
        this.frame = frame;
        init(this.frame);
    }

    public void show() {
        frame.setVisible(true);
    }


    void init(JFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationByPlatform(true);
        frame.setTitle("Twinkle");
    }


}
