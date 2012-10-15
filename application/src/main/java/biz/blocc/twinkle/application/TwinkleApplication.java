package biz.blocc.twinkle.application;

import javax.swing.*;

public class TwinkleApplication {

    public static void main(String[] args) {
        final JFrame frame = new JFrame("Twinkle");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
