package biz.blocc.twinkle.gui;

import biz.blocc.twinkle.application.TwinkleApplication;
import biz.blocc.twinkle.gui.action.ExitActionListener;

import javax.swing.*;

public class AppFrame {

    public static AppFrame create(TwinkleApplication application) {
        final AppFrame appFrame = new AppFrame(new JFrame());
        appFrame.setApplication(application);
        return appFrame;
    }

    public void show() {
        frame.setVisible(true);
    }

    //---------------------------------------------------------------------------
    //----- End of public -------------------------------------------------------
    //---------------------------------------------------------------------------

    private TwinkleApplication application;
    private JFrame frame;

    AppFrame(JFrame frame) {
        this.frame = frame;
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

    private void setApplication(TwinkleApplication application) {
        this.application = application;
    }
}
