package Utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class DriverManager {
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    PropertyFile propertyFile = new PropertyFile();


    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2) {
        driver.set(driver2);
    }


    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        Properties properties = propertyFile.getProperty("src/test/resources/configuration.properties");
        final String APP = properties.getProperty("APP");//"C:\\Users\\paragdwivedi\\Downloads\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
        final String appiumServer = properties.getProperty("appiumServer");
        //properties.getProperty("appiumServer");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(properties.getProperty("deviceName"))
                .setPlatformVersion(properties.getProperty("platformVersion"))
                .setApp(APP)
                .setAppPackage(properties.getProperty("appPackage"))
                .setAppActivity(properties.getProperty("appActivity"));

        try {

            driver = new AndroidDriver(new URL(appiumServer), options);

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }
}