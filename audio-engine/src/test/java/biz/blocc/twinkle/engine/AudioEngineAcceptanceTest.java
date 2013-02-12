package biz.blocc.twinkle.engine;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class AudioEngineAcceptanceTest {

    private List deviceNames;

    @BeforeClass
    public void setUpClass() throws ConfigurationException {
        final String userName = System.getProperty("user.name");
        final String osName = System.getProperty("os.name");
        final String osVersion = System.getProperty("os.version");
        final String javaVersion = System.getProperty("java.version");
        final StringBuilder propertyName = new StringBuilder(64);
        propertyName.append("/biz/blocc/twinkle/engine/Devices_");
        propertyName.append(userName);
        propertyName.append("_");
        propertyName.append(osName);
        propertyName.append("_");
        propertyName.append(osVersion);
        propertyName.append("_");
        propertyName.append(javaVersion);
        propertyName.append(".properties");


        String deviceResourceUrl = propertyName.toString();
        deviceResourceUrl = deviceResourceUrl.replace(" ", "_");
        final URL propertyStream = AudioEngineAcceptanceTest.class.getResource(deviceResourceUrl);
        final PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration(propertyStream);
        deviceNames = propertiesConfiguration.getList("device.name");
    }

    @Test
    public void testDevices() throws ConfigurationException {
        final AudioEngine audioEngine = AudioEngine.create();
        final IODevice[] devices = audioEngine.getDevices();
        assertEquals(devices.length, deviceNames.size());
        for (final IODevice device : devices) {
            final String name = device.getName();
            assertDeviceNameInList(name, deviceNames);
        }
    }

    private void assertDeviceNameInList(String name, List deviceNames) {
        for (Object deviceName : deviceNames) {
            final String nameFromList = (String) deviceName;
            if (name.equalsIgnoreCase(nameFromList)) {
                return;
            }
        }
        fail("expected device name not in list: " + name);
    }
}


