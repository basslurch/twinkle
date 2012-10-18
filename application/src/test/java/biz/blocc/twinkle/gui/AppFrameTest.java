package biz.blocc.twinkle.gui;

import biz.blocc.twinkle.application.TwinkleApplication;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertNotNull;

public class AppFrameTest {

    private JFrame frameMock;

    @BeforeMethod
    public void setUp() {
        frameMock = mock(JFrame.class);
    }

    @Test
    public void testShow() {
        final AppFrame appFrame = new AppFrame(frameMock);
        appFrame.show();

        verify(frameMock, times(1)).setVisible(true);
    }

    @Test
    public void testInitFrame() {
        final AppFrame appFrame = new AppFrame(new JFrame());

        appFrame.init(frameMock);

        verify(frameMock, times(1)).setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        verify(frameMock, times(1)).setSize(300, 200);
        verify(frameMock, times(1)).setLocationByPlatform(true);
        verify(frameMock, times(1)).setTitle("Twinkle");
    }

    @Test
    public void testCreate() {
        final TwinkleApplication application = mock(TwinkleApplication.class);

        final AppFrame appFrame = AppFrame.create(application);
        assertNotNull(appFrame);
    }
}
