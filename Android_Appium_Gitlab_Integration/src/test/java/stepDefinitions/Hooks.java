package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import org.LaunchEmulator;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Logger;

public class Hooks extends LaunchEmulator {
    Logger logger = Logger.getLogger(Hooks.class.getName());


    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

        String browserstackUsername = System.getenv("BROWSERSTACK_USERNAME");
        String browserstackAccessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        String buildName = System.getenv("BUILD_NAME");
        String browserstackDeviceName = System.getenv("DEVICE_NAME");
        String Os_version = System.getenv("OS_VERSION");
        String platformName = System.getenv("PLATFORM_NAME");
        String app = System.getenv("BROWSERSTACK_APP_URL");
        String browserstackUrl = System.getenv("BROWSERSTACK_SERVER_URL");


        browserstackOptions.put("userName", browserstackUsername);
        browserstackOptions.put("accessKey", browserstackAccessKey);
        browserstackOptions.put("buildName", buildName);
        desiredCapabilities.setCapability("appium:deviceName", browserstackDeviceName);
        desiredCapabilities.setCapability("appium:os_version", Os_version);
        desiredCapabilities.setCapability("appium:app", app);
        desiredCapabilities.setCapability("platformName", platformName);
        desiredCapabilities.setCapability("bstack:options", browserstackOptions);

        URL remoteUrl = new URL("http://hub.browserstack.com/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);


    }

}