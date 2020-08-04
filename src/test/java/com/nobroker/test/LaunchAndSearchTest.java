package com.nobroker.test;

import com.nobroker.framework.TestBaseTest;
import com.nobroker.pageobject.LaunchAndSearchPage;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class LaunchAndSearchTest extends TestBaseTest {

    public static LaunchAndSearchPage launchAndSearchPage;

    @BeforeClass
    public static void beforeSuit() throws MalformedURLException {
        initialSetup();
        launchApp();
        launchAndSearchPage = new LaunchAndSearchPage(getAppiumDriver());
    }

    @AfterClass
    public static void afterSuit() throws InterruptedException {
        //Thread.sleep(5000);
        TestBaseTest.closeApp();
    }

    /* The test to verify if app is asking for permission,
     if yes the the method will allow the permission.
      */
    @Test(priority = 1)
    public void verifyPermissionEnable() throws InterruptedException {

        launchAndSearchPage.verifyPermissionEnable();
    }

    /* The test case will check the Buy button and tap over to it. */

    @Test(priority = 2)
    public void verifyBuyButtonTap(){
        //LaunchAndSearchPage launchAndSearchPage = new LaunchAndSearchPage(getAppiumDriver());
        launchAndSearchPage.verifyBuyButtonTap();
    }

    @Test(priority = 3)
    public void verifyBangaloreSelection() {
      //  LaunchAndSearchPage launchAndSearchPage = new LaunchAndSearchPage(getAppiumDriver());
        launchAndSearchPage.verifyBangaloreSelection();
    }

    @Test(priority = 4)
    public void verifySearchButton(){
       // LaunchAndSearchPage launchAndSearchPage = new LaunchAndSearchPage(getAppiumDriver());
        /*launchAndSearchPage.verifyPermissionEnable();
        launchAndSearchPage.verifyBuyButtonTap();
        launchAndSearchPage.verifyBangaloreSelection();*/
        launchAndSearchPage.verifySearchButton();
    }

}
