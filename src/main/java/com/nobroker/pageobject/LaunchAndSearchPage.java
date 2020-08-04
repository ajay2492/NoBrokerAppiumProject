package com.nobroker.pageobject;

import com.nobroker.framework.Constant;
import com.nobroker.framework.ConstantMessages;
import com.nobroker.framework.LoggerUtils;
import com.nobroker.framework.TestBasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.touch.offset.PointOption;

public class LaunchAndSearchPage extends TestBasePage {

    public static AppiumDriver<MobileElement> appiumDriver;
   // public static TouchAction touchAction;
    protected static String cityToSelect;

    public LaunchAndSearchPage(){
        super();
    }

    public LaunchAndSearchPage(AppiumDriver<MobileElement> inputdriver) {
        super(inputdriver);
        appiumDriver = inputdriver;
        //touchAction= new TouchAction(appiumDriver);
    }

    /* The getContinue method is designed to search & return for permission continue */

    protected static MobileElement getContinue() {
        return findElementById("bottomPermission");
    }

    /* The getBuyButton method is designed to search & return for Buy button */

    protected static MobileElement getBuyButton() {
        return findElementById("buyLayoutText");
    }

    /* The getSearchBox method is designed to search & return for search box */

    protected static MobileElement getSearchBox() {
        return findElementById("searchEditHome");
    }

    /* The getCityBox method is designed to search & return the city box element */

    protected static MobileElement getCityBox() {
        return findElementByPackageId("android:id/text1");
    }

    /* The getSearchLocalityBox method is designed to search & return for Seacrh Locality box */

    protected static MobileElement getSearchLocalityBox() {
        return findElementById("localityAutoCompleteTxt");
    }

    /* The getNearByRadioButton method is designed to search & return the near by radio button */

    protected static MobileElement getNearByRadioButton(){
        return findElementById("nearByRadio");
    }

    /* The get2bhkButton method is designed to search & return the buttn element for 2 BHK */

    protected static MobileElement get2bhkButton(){
        return findElementById("bhktwo");
    }

    /* The get3bhkButton method is designed to search & return the buttn element for 3 BHK */

    protected static MobileElement get3bhkButton(){
        return findElementById("bhkthree");
    }

    /* The getSearchPropertybutton method is designed to search & return the Search Property button */

    protected static MobileElement getSearchPropertybutton(){
        return findElementById("searchProperty");
    }

    /* The method getHSRLayout is designed to search for HSR Layout and click on it. */

    protected static void getHSRLayout() {
        int height = getScreenHeight();
        int width = getScreenWidth();
        int y = (int) (height / 2.6);
        int x = width / 2;
        //TouchAction t = new TouchAction(appiumDriver);
        touchAction.tap(PointOption.point(x, y)).perform();
    }

    /* The method getMarathahalli is designed to search for marathahalli and click on it. */

    protected static void getMarathahalli() {
        int height = getScreenHeight();
        int width = getScreenWidth();
        int y = (int) (height / 2.6);
        int x = width / 2;
      //  TouchAction t = new TouchAction(appiumDriver);
        touchAction.tap(PointOption.point(x, y)).perform();
    }

    /* The method verifyPermissionEnable is designed to check if app is asking for permision */

    public static void verifyPermissionEnable() {
        implicitWait();
        System.out.println("The value of Continue botton" + getContinue().isDisplayed());
        getContinue().click();
    }

    /* The method verifyBuyButtonTap is designed to verify Buy and slect the Buy option.
     * Once the Buy option is selected then, the script will tap to search location. */

    public static void verifyBuyButtonTap() {
        implicitWait();
        if (getBuyButton().isDisplayed()) {
            getBuyButton().click();
        } else {
            LoggerUtils.error(ConstantMessages.BUY_BUTTON_ERROR);
        }
        if (getSearchBox().isDisplayed()) {
            getSearchBox().click();
        } else {
            LoggerUtils.error(ConstantMessages.SEARCH_BOX_ERROR);
        }
    }
    /* The below method is designed to verify if Banaglore is selected.
     * If Bangalore is not selected it will open the available list and search for Banglore.
     * Once the script received the Bangalore it will select.
     * If it's required to move to different city then change the value of "cityToSelect" in config file.  */

    public static void verifyBangaloreSelection() {
        LoggerUtils.info(ConstantMessages.SELECTED_CITY + getCityBox().getText() + "\n" +
                ConstantMessages.CITY_TO_SELECT);
        cityToSelect = getValue("cityToSelect");

        if (!(getCityBox().getText().equalsIgnoreCase(cityToSelect))) {
            getCityBox().click();
            findElementByText(cityToSelect).click();
        }
        /* Multiple static wait is used beacuse of delay in API response */
        getSearchLocalityBox().sendKeys("HSR");
        staticWait(Constant.STATIC_WAIT2_SEC);
        getHSRLayout();
        staticWait(Constant.STATIC_WAIT1_SEC);
        getSearchLocalityBox().sendKeys("Marathahalli");
        staticWait(Constant.STATIC_WAIT2_SEC);
        getMarathahalli();
    }

    /* The verifySearchButton is designed to click on near by propert button.
    * Once the near by is clicked it will click the 2 BHK & 3 BHK.
    * Once the flat option is selected then Search property button will be selected. */

    public static void verifySearchButton(){
        if(getNearByRadioButton().isDisplayed()){
            getNearByRadioButton().click();
        }else{
            LoggerUtils.error(ConstantMessages.NEAR_BY_BUTTON_ERROR);
        }
        if(get2bhkButton().isDisplayed()){
            get2bhkButton().click();
        }else{
            LoggerUtils.error(ConstantMessages.TWO_BHK_ERROR);
        }
        if(get3bhkButton().isDisplayed()){
            get3bhkButton().click();
        }else{
            LoggerUtils.error(ConstantMessages.THREE_BHK_ERROR);
        }
        if(getSearchPropertybutton().isDisplayed()){
            getSearchPropertybutton().click();
        }else{
            LoggerUtils.error(ConstantMessages.SEARCH_PROPERTY_ERROR);
        }
    }
}
