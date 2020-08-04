package com.nobroker.pageobject;

import com.nobroker.framework.Constant;
import com.nobroker.framework.ConstantMessages;
import com.nobroker.framework.LoggerUtils;
import com.nobroker.framework.TestBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;

import java.util.List;

public class PropertycategoryPage extends TestBasePage {

    private static AppiumDriver<MobileElement> appiumDriver;

    private static final String expecteStringValue = "Thank you for the feedback";

    public PropertycategoryPage(AppiumDriver<MobileElement> inputDriver) {
        super(inputDriver);
        appiumDriver = inputDriver;
    }

    /* The getContactList is designed to return the list of the contact Mobile elements  */

    protected static List<MobileElement> getContactList() {
        return findElementsById("property_item_contact_owner");
    }

    /* The getEmiList is designed to return the list of the EMI Mobile elements  */

    protected static List<MobileElement> getEmiList() {
        return findElementsById("property_emi_per_month");
    }

    protected static MobileElement getEMIText() {
        return findElementById("property_emi_per_month");
    }

    protected static MobileElement getEMITextInDetails() {
        return findElementById("emi_info_title");
    }

    protected static MobileElement getWrongButton() {
        return findElementById("tv_report_wrong_info");
    }

    protected static MobileElement getLocationCheckBox() {
        return findElementById("cb_location");
    }

    protected static MobileElement getFakePhotosCheckBox() {
        return findElementById("cb_fake_photos");
    }

    protected static MobileElement getBhkCheckBOX() {
        return findElementById("cb_bhk_type");
    }

    protected static MobileElement getAvailabilityCheckBox() {
        return findElementById("cb_availability_date");
    }

    protected static MobileElement getPriceCheckBox() {
        return findElementById("cb_price");
    }

    protected static MobileElement getOtherCheckBox() {
        return findElementById("cb_other");
    }

    protected static MobileElement getReportButton() {
        return findElementById("btn_report");
    }

    protected static MobileElement getConfiguration2BHKDropDown() {
        return findElementByText("2 BHK");
    }

    protected static MobileElement getConfiguration3BHKDropDown() {
        return findElementByText("3 BHK");
    }

    protected static MobileElement getConfiguration4BHKDropDown() {
        return findElementByText("4 BHK");
    }

    protected static MobileElement getSaveButton() {
        return findElementById("btn_save");
    }

    protected static MobileElement getWrongEditBox() {
        return findElementById("edt_others");
    }

    protected static MobileElement getAlertboxmessage() {
        return findElementByText("Thank you for the feedback");
    }

    protected static MobileElement getSaveChanges() {
        return findElementByText("Save Changes");
    }

    /* The verifyCategory is designed to scroll till 4th property.
     * Once the method reach to 4th property, method will open the details of the property.
     * The Method will also verify the script is getting clicked to correct element */

    public static void verifyCategory() {
        //staticWait(Constant.STATIC_WAIT5_SEC);
        implicitWait();
        for (int i = 1; i < Constant.PROPERTY_TO_SELECT; i++) {

            List<MobileElement> contact = getContactList();
            dragAndDrop(contact.get(1), contact.get(0));
        }
        String expectedEmi = getEmiList().get(0).getText();
        getEmiList().get(0).click();
        Assert.assertEquals(expectedEmi, getEMITextInDetails().getText());
    }

    /* The verifyScrollTillend is designed to look for "Wrong Info" button if the button is not visible,
     * the script will do scrolling, the scrolling will continue till the "Wrong Info" button become enable.
     * Once the button is visible the script will tap to the button. */

    public static void verifyScrollTillend() {

        try {
            if (!getWrongButton().isDisplayed()) {
                scrollTopToBottom();
                verifyScrollTillend();
            } else {
                if(getWrongButton().isDisplayed()){
                getWrongButton().click();
                }else{
                    Assert.fail("The driver is not able to find the element");
                }
            }
        } catch (Exception e) {
            scrollTopToBottom();
            verifyScrollTillend();
        }
    }

    public static void LoginIfUserIsNotLogin() {
        LoginPage loginPage = new LoginPage(appiumDriver);
        try{
        if (LoginPage.getNumberTextBox().isDisplayed()) {
            loginPage.verifyLogin();
        }}catch (Exception e){
            LoggerUtils.error(e.getMessage());
        }
    }

    public static void verifyWhatsWrongOptions() {
        Assert.assertTrue(getLocationCheckBox().isDisplayed());
        getLocationCheckBox().click();
        Assert.assertTrue(getFakePhotosCheckBox().isDisplayed());
        getFakePhotosCheckBox().click();
        Assert.assertTrue(getBhkCheckBOX().isDisplayed());
        getBhkCheckBOX().click();
        Assert.assertTrue(getAvailabilityCheckBox().isDisplayed());
        getAvailabilityCheckBox().click();
        Assert.assertTrue(getPriceCheckBox().isDisplayed());
        getPriceCheckBox().click();
        Assert.assertTrue(getOtherCheckBox().isDisplayed());
        getOtherCheckBox().click();
        Assert.assertTrue(getReportButton().isDisplayed());
        getReportButton().click();
        implicitWait();
    }

    public static void verifySuggetedAnEdit() {
        boolean elementVisible = false;
        try {
            if (getConfiguration2BHKDropDown().isDisplayed()) {
                getConfiguration2BHKDropDown().click();
            }
        } catch (Exception e) {
            LoggerUtils.error(ConstantMessages.BHK_2_ERROR);
        }
        try {
            if (getConfiguration3BHKDropDown().isDisplayed()) {
                getConfiguration3BHKDropDown().click();
            }
        } catch (Exception e) {
            LoggerUtils.error(ConstantMessages.BHK_3_ERROR);
        }
        //  implicitWait();
        getConfiguration4BHKDropDown().click();
        getSaveButton().click();
        scrollTopToBottom();
        getWrongEditBox().sendKeys("No Info");
        // implicitWait();
        getSaveButton().click();
    }

    public static void verifyFeedbackMessage() {
        String actualString = getAlertboxmessage().getText();
        Assert.assertEquals(actualString, expecteStringValue);
    }

    public static void launchPropertyCategoryPage(AppiumDriver appiumDriver) {
        LaunchAndSearchPage launchAndSearchPage = new LaunchAndSearchPage(appiumDriver);
        launchAndSearchPage.verifyPermissionEnable();
        launchAndSearchPage.verifyBuyButtonTap();
        launchAndSearchPage.verifyBangaloreSelection();
        launchAndSearchPage.verifySearchButton();
    }
}
