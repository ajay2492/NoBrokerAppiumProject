package com.nobroker.test;

import com.nobroker.framework.TestBaseTest;
import com.nobroker.pageobject.PropertycategoryPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class PropertyCategoryTest extends TestBaseTest{

    //private static LaunchAndSearchPage launchAndSearchPage;
    public static PropertycategoryPage propertycategoryPage;

    @BeforeClass
    public static void beforeSuit() throws MalformedURLException {
        initialSetup();
        launchApp();
        PropertycategoryPage.launchPropertyCategoryPage(getAppiumDriver());
        propertycategoryPage = new PropertycategoryPage(getAppiumDriver());
    }

    @AfterClass
    public static void afterSuit() throws InterruptedException {

        TestBaseTest.closeApp();
    }

    /* The test case will verify the selection of 4th available property */

    @Test(priority = 1)
    public static void verifyCategory(){
        //PropertycategoryPage propertycategoryPage = new PropertycategoryPage(getAppiumDriver());
        propertycategoryPage.verifyCategory();
    }

    /* The test case will verify the user is able to scroll till end.
    * And also once the wrong information is visible then it will stop scrolling and click on the element. */

    @Test(priority = 2)
    public static void verifyScrollTillend(){
       // PropertycategoryPage propertycategoryPage = new PropertycategoryPage(getAppiumDriver());
        propertycategoryPage.verifyScrollTillend();
        propertycategoryPage.LoginIfUserIsNotLogin();
    }

    /* The test case will click to all the available option in what's wrong window */

    @Test(priority = 3)
    public static void verifyWhatsWrongOptions(){
        //PropertycategoryPage propertycategoryPage = new PropertycategoryPage(getAppiumDriver());
        propertycategoryPage.verifyWhatsWrongOptions();
    }

    /* The test case will verify the task in a suggest an edit screen */

    @Test(priority = 4)
    public static void verifySuggetedAnEdit(){
       // PropertycategoryPage propertycategoryPage = new PropertycategoryPage(getAppiumDriver());
        propertycategoryPage.verifySuggetedAnEdit();
    }

    /* The test case will verify the final tast to verify the test message in feedback popup*/

    @Test(priority = 5)
    public static void verifyFeedbackMessage(){
        propertycategoryPage.verifyFeedbackMessage();
    }
}
