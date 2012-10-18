package biz.blocc.twinkle.acceptance;

import biz.blocc.twinkle.application.TwinkleApplication;
import org.uispec4j.MenuBar;
import org.uispec4j.MenuItem;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.interception.MainClassAdapter;

public class MenuTest extends UISpecTestCase {

    @Override
    protected void setUp() throws Exception {
        setAdapter(new MainClassAdapter(TwinkleApplication.class));
    }

    public void testFileMenuItemsPresent() {
        final Window mainWindow = getMainWindow();

        final MenuBar menuBar = mainWindow.getMenuBar();
        final MenuItem fileMenu = menuBar.getMenu("File");
        final MenuItem exitMenuItem = fileMenu.getSubMenu("Exit");
        assertNotNull(exitMenuItem);
    }
}
