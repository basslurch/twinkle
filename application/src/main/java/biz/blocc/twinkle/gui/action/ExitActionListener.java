package biz.blocc.twinkle.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitActionListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        System.out.println("Application exit");
        System.exit(0);
    }
}
