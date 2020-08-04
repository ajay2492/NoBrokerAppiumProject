package com.nobroker.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseTest {

    public static AppiumDriver<MobileElement> driver;

    public static void initialSetup() {
        TestBasePage.beforeSuit();
        TestBasePage.loadConfigFile();
    }

    public static void closeApp() {
        TestBasePage.closeConnection();
    }

    public static void launchApp() throws MalformedURLException {
        URL url = new URL(TestBasePage.getValue("url"));
        driver = new AppiumDriver<MobileElement>(url, getCapabilities());
    }

    public static AppiumDriver<MobileElement> getAppiumDriver() {
        return driver;
    }

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", TestBasePage.getValue("deviceId"));
        capabilities.setCapability("udid", TestBasePage.getValue("udid"));
        capabilities.setCapability("platformName", TestBasePage.getValue("platformName"));
        capabilities.setCapability("platformVersion", TestBasePage.getValue("paltformVersion"));
        capabilities.setCapability("appPackage", TestBasePage.getValue("appPackage"));
        capabilities.setCapability("appActivity", TestBasePage.getValue("appActivity"));
        capabilities.setCapability("noRest", TestBasePage.getValue("noRest"));
        capabilities.setCapability("autoGrantPermissions",TestBasePage.getValue("autoGrantPermissions"));
        return capabilities;
    }

}
