package biz.blocc.twinkle.engine;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IODeviceTest {

    @Test
    public void testSetGetName() {
        final IODevice ioDevice = new IODevice();
        final String name_1 = "the Device";
        final String name_2 = "AnotherDevice";

        ioDevice.setName(name_1);
        assertEquals(name_1, ioDevice.getName());

        ioDevice.setName(name_2);
        assertEquals(name_2, ioDevice.getName());
    }
}
