package StepDefinition;

import Utility.PropertyFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        final String appiumServer =properties.getProperty("appiumServer");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(properties.getProperty("deviceName"))
                .setPlatformVersion(properties.getProperty("platformVersion"))
                .setApp(APP)
                .setAppPackage(properties.getProperty("appPackage"))
                .setAppActivity(properties.getProperty("appActivity"));


        try {
           driver = new AndroidDriver(new URL(appiumServer), options);
           // driver.set(new AndroidDriver(new URL(appiumServer), options));

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return driver;
    }

    public void clean(){
        logger.info("quitting the driver");
        if(driver != null) {
            driver.quit();
        }
    }


}
