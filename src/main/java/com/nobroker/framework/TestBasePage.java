package com.nobroker.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class TestBasePage {

    private static AppiumDriverLocalService server;
    private static AppiumDriver<MobileElement> appiumDriver;
    private static WebDriverWait explicitWait;
    protected static Properties properties;
    public static TouchAction touchAction;

    public TestBasePage() {

    }

    public TestBasePage(AppiumDriver<MobileElement> inputDriver) {
        appiumDriver = inputDriver;
        touchAction= new TouchAction(appiumDriver);
    }

    public static void beforeSuit() {
        server = getAppiumServerDefault();
        if (server.isRunning()) {
            server.stop();
        }
        server.start();
        System.out.println(server.isRunning());
        //explicitWait = new WebDriverWait(appiumDriver,Constant.EXPLICIT_WAIT);
    }

    public static AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }


    public static void loadConfigFile() {

        {
            properties = new Properties();
            try {
                FileInputStream fileInputStream = new FileInputStream("./config/config.properties");
                //Logger.info("Loading Config file to properties Object");
                properties.load(fileInputStream);

            } catch (FileNotFoundException e) {
                LoggerUtils.error(e.getMessage());
            } catch (IOException e) {
                LoggerUtils.error(e.getMessage());
            }
        }
    }

    public static String getValue(String configKey) {
        return properties.getProperty(configKey);
    }

    public static void closeConnection() {
        server.stop();
    }

    /* The findElementById method is designed to search the mobile element by Id,
     * the method will take package name as com.nobroker.app:id/ from constant file. */

    public static MobileElement findElementById(String idValue) {
        return (MobileElement) appiumDriver.findElementById(Constant.PACKAGE_NAME + idValue);
    }

    public static MobileElement findElementByPackageId(String packageWithId) {
        return (MobileElement) appiumDriver.findElementById(packageWithId);
    }

    public static List<MobileElement> findElementsById(String inputId) {
        return appiumDriver.findElementsById(Constant.PACKAGE_NAME + inputId);
    }

    public static MobileElement findElementByAccessibilityId(String accessibilityId){
        return appiumDriver.findElementByAccessibilityId(accessibilityId);
    }

    public static MobileElement findElementByText(String inputText) {

        try {
            return (MobileElement) appiumDriver.findElementByXPath("//*[@content-desc=\"" + inputText + "\"" +
                    " or @resource-id=\"" + inputText + "\" or @text=\"" + inputText
                    + "\"] | //*[contains(translate(@content-desc,\"" + inputText + "\",\"" + inputText + "\"), \"" + inputText
                    + "\") or contains(translate(@text,\"" + inputText + "\",\"" + inputText + "\"), \"" + inputText
                    + "\") or @resource-id=\"" + inputText + "\"]");
        } catch (Exception e) {
            LoggerUtils.error("Element with text value as " + inputText + "is not found  \n" + e.getMessage());
            return null;
        }

    }

  /*  public static void explicitWaitById(String elementToVisible) {
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementToVisible)));
    }*/

    public static void implicitWait() {
        appiumDriver.manage().timeouts().implicitlyWait(Constant.EXPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public static int getScreenHeight() {
        return appiumDriver.manage().window().getSize().getHeight();
    }

    public static int getScreenWidth() {
        return appiumDriver.manage().window().getSize().getWidth();
    }

    public static void staticWait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            LoggerUtils.error(e.getMessage());
        }
    }

    public static void swiptToBottom() {
        Dimension dim = appiumDriver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width / 2;
        int top_y = (int) (height * 0.80);
        int bottom_y = (int) (height * 0.20);
        System.out.println("coordinates :" + x + "  " + top_y + " " + bottom_y);
      //  TouchAction ts = new TouchAction(appiumDriver);
        touchAction.press(PointOption.point(x, top_y)).moveTo(PointOption.point(x, bottom_y)).release().perform();
    }

    public static void dragAndDrop(MobileElement element1, MobileElement element2) {
        touchAction.longPress(longPressOptions()
                .withElement(ElementOption.element(element1)))
                .moveTo(ElementOption.element(element2))
                .release().perform();
    }

    public static void scrollTopToBottom(){
        int height = getScreenHeight();
        int width = getScreenWidth();
        int x = width/2;
        int y = (int) (height/1.1);
        int endy = (int) (height/9);
        touchAction.press(PointOption.point(x,y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(x,endy)).release().perform();
    }

    public static void clickbyCordinates(int xcordinate, int ycordinate){
        touchAction.tap(PointOption.point(xcordinate,ycordinate)).release().perform();
    }
}
