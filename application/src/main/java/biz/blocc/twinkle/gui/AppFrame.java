package biz.blocc.twinkle.gui;

import biz.blocc.twinkle.application.TwinkleApplication;
import biz.blocc.twinkle.gui.action.ExitActionListener;

import javax.swing.*;

public class AppFrame {

    public static AppFrame create(TwinkleApplication application) {
        return new AppFrame(new JFrame(), application);
    }

    public void show() {
        frame.setVisible(true);
    }

    //---------------------------------------------------------------------------
    //----- End of public -------------------------------------------------------
    //---------------------------------------------------------------------------

    private final TwinkleApplication application;
    private final JFrame frame;

    AppFrame(JFrame frame, TwinkleApplication application) {
        this.frame = frame;
        this.application = application;
        init(this.frame);
    }

    void init(JFrame frame) {
        createMainWindow(frame);

        final JMenuBar menuBar = new JMenuBar();
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ExitActionListener(application));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);


        frame.setJMenuBar(menuBar);
    }

    private void createMainWindow(JFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationByPlatform(true);
        frame.setTitle("Twinkle");
    }
}
