package StepDefinition;

import Utility.PropertyFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    public AppiumDriver driver;


    public AppiumDriver setup() throws IOException {
        PropertyFile propertyFile = new PropertyFile();
        Properties properties = propertyFile.getProperty("src/test/resources/configuration.properties");

        logger.info("Setting up the driver");
        final String APP = properties.getProperty("APP");
        final String appiumServer = properties.getProperty("appiumServer");
        final String deviceType = properties.getProperty("deviceType");

        try {
            if(deviceType.equalsIgnoreCase("android")) {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setDeviceName(properties.getProperty("deviceName"))
                .setPlatformVersion(properties.getProperty("platformVersion"))
                .setApp(APP)
                .setAppPackage(properties.getProperty("appPackage"))
                .setAppActivity(properties.getProperty("appActivity"));
                driver = new AndroidDriver(new URL(appiumServer), options);
                // driver.set(new AndroidDriver(new URL(appiumServer), options));
            }else if(deviceType.equalsIgnoreCase("ios")){
                driver = startAppium_IOS();
            }

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }

    /*
     * This method is used for initiate the IOSDriver with caps and connection protocol
     */
    public IOSDriver startAppium_IOS() {
        // Initializing the Appium driver
        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "17.2");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 15 Pro Max");
            cap.setCapability(MobileCapabilityType.UDID, "auto");
          //  cap.setCapability("bundleId", "io.appium");
            cap.setCapability("autoLaunch", true);
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            cap.setCapability(MobileCapabilityType.APP, "src/test/resources/APK/TestApp.app");
// driver is declared as an IOSDriver, which supports IOSElements
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), cap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Returning the instance of the driver to the parent method
        return (IOSDriver) driver;
    }

    public void clean(){
        logger.info("quitting the driver");
        if(driver != null) {
            driver.quit();
        }
    }


}
