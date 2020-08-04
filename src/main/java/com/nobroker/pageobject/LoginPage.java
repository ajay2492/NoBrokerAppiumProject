package com.nobroker.pageobject;

import com.nobroker.framework.Constant;
import com.nobroker.framework.ConstantMessages;
import com.nobroker.framework.LoggerUtils;
import com.nobroker.framework.TestBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;

public class LoginPage extends TestBasePage {

    private static AppiumDriver<MobileElement> appiumDriver;

    public LoginPage(){};
    public LoginPage(AppiumDriver<MobileElement> inputDriver){
        appiumDriver = inputDriver;
    }

    protected static MobileElement getProfileButton(){
        return findElementByAccessibilityId("Navigate up");
    }
    protected static MobileElement getUserPic(){
        return findElementById("imgUserPic");
    }
    protected static MobileElement getNumberTextBox(){
        return findElementById("et_signup_phone");
    }
    protected static MobileElement getSignUpButton(){
        return findElementById("btn_signup");
    }
    protected static MobileElement getSignUpPassword(){
        return findElementById("rb_signup_pwd");
    }
    protected static MobileElement getPasswordTextBox(){
        return findElementByText("Enter Password");
    }

    public static void verifyProfileButton(){
        if(!(getProfileButton().isDisplayed())){
            LoggerUtils.error(ConstantMessages.PROFILE_BUTTON_ERROR);
            Assert.fail();
        }else {
            getProfileButton().click();
        }
        if (!(getUserPic().isDisplayed())){
            LoggerUtils.error(ConstantMessages.USER_PROFILE_PIC_ERROR);
            Assert.fail();
        }
    }

    public static void verifyLogin(){
        if(getNumberTextBox().isDisplayed()){
            getNumberTextBox().sendKeys(getValue("mobileNumber"));
            staticWait(Constant.STATIC_WAIT2_SEC);
            /* we are click to the screen so app will not wait for auto read */
            clickbyCordinates(512,427);

        }else{
            LoggerUtils.error(ConstantMessages.NUMBER_TEXT_BOX_ERROR);
        }
        /*if (getSignUpButton().isDisplayed()){
            getSignUpButton().click();
            staticWait(Constant.STATIC_WAIT2_SEC);
            *//* we are click to the screen so app will not wait for auto read *//*
            clickbyCordinates(512,427);
            staticWait(Constant.STATIC_WAIT1_SEC);
        }else {
            LoggerUtils.error(ConstantMessages.SIGNUP_BUTTON_ERROR);
        }*/
        if(getSignUpPassword().isDisplayed()){
            getSignUpPassword().click();
        }else {

        }
        if(getPasswordTextBox().isDisplayed()){
            getPasswordTextBox().sendKeys(getValue("password"));
            getSignUpButton().click();
        }
    }

}
