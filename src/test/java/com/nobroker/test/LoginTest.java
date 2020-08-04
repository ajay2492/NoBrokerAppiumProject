package com.nobroker.test;

import com.nobroker.framework.TestBaseTest;
import com.nobroker.pageobject.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginTest extends TestBaseTest {

    public static LaunchAndSearchTest launchAndSearchTest;

    @BeforeClass
    public static void beforeSuit() throws MalformedURLException {
        initialSetup();
        launchApp();
        launchAndSearchTest = new LaunchAndSearchTest();
    }

    @AfterClass
    public static void afterSuit() throws InterruptedException {
        //Thread.sleep(5000);
        TestBaseTest.closeApp();
    }

    @Test
    public static void verifyProfileButton() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getAppiumDriver());
        launchAndSearchTest.verifyPermissionEnable();
        loginPage.verifyProfileButton();
    }
    @Test
    public static void verifyLogin(){
        LoginPage loginPage = new LoginPage(getAppiumDriver());
        loginPage.verifyLogin();
    }
}
