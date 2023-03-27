package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import org.LaunchEmulator;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Hooks extends LaunchEmulator {

    @Before
    public void setUp() throws MalformedURLException {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

        browserstackOptions.put("userName", "rahulkumar_gfLNsr");
        browserstackOptions.put("accessKey", "4cwaRV1h9xEZxppJKmfy");
        browserstackOptions.put("buildName", "alpha_0.1.7");
        desiredCapabilities.setCapability("appium:deviceName", "Samsung Galaxy S22");
        desiredCapabilities.setCapability("appium:os_version", "12.0");
        desiredCapabilities.setCapability("appium:app", "bs://51297b5467438047eb2e336a0d3ab0ecccc72fd1");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("bstack:options", browserstackOptions);

        URL remoteUrl = new URL("http://hub.browserstack.com/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }


}


