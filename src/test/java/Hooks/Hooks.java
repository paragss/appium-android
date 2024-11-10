package Hooks;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);
    public static AppiumDriverLocalService service;
    public void startAppium() {
        logger.info("Starting the appium server");
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        logger.info("Server started");

    }


    public void stopAppium() {
        System.out.println("service: "+service.toString());
        logger.info("Stopping the appium server");
        service.stop();
    }
}
