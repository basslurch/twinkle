package biz.blocc.twinkle.gui.action;

import biz.blocc.twinkle.application.TwinkleApplication;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ExitActionListenerTest {

    @Test
    public void testActionPerformed() {
        final TwinkleApplication application = mock(TwinkleApplication.class);

        final ExitActionListener listener = new ExitActionListener(application);
        listener.actionPerformed(null); // event is not used

        verify(application, times(1)).exitApplication();
    }
}
