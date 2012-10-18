package biz.blocc.twinkle.gui.action;

import biz.blocc.twinkle.application.TwinkleApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitActionListener implements ActionListener{

    public ExitActionListener(TwinkleApplication application) {
        this.application = application;
    }

    public void actionPerformed(ActionEvent e) {
        application.exitApplication();
    }

    ////////////////////////////////////////////////////////////////////////////////
    /////// END OF PUBLIC
    ////////////////////////////////////////////////////////////////////////////////

    private TwinkleApplication application;
}
