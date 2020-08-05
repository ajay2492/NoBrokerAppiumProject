# The frame work is designed for NoBrokerAppiumProject #

The frame work is based on page object model, as per the given task I created only 3 pages.

The below are the 3 pages details:
  - Login page, this page have an elements for the login page like side menu button, login button etc.
  - LaunchAndSearchTest page is designer with the combination of two page i.e launch screen and buy search option, this
  class have elements for app launch screen like continue with permission and with "Buy" option to search 
  property and having elements of like select city, select locality etc.
  - PropertyCategoryTest is designed with combination of property category screen, property details, wrong information &
   suggested edit.
  -  PropertyCategoryTest have an elements like wrong button, search for wrong button, select 4th available property,
   if user is not logged int the use login page elements to login into app, etc.
  - All the test cases is written in the pagename with an extension as Test like LoginTest, LaunchAndSearchTest, etc.
  - The implimentation and assert condition are written in the pagename with extension as LoginPage, LaunchAndSearchPage,
   etc.
   
# FrameWork Configuration

# - Prerequisite
    - The Java should be installed in it's machine and Java path should be setuped.
    - The Apache Maven should be installed and path should be configured as environment variale in machine.
    - Android studio & Adb should be installed, should be configured in system variale.
    
# - If the user is using Intellij IDEA CE, below are the configuration.
    - Select the Intellij prefrences, and move to the "plugins".
    - Select the installed pluged in & search for TestNG and Create TestNG XML. 
    - If the plugein is not installed then move to market place and installed it.
    - Go to the Run option and select Edit Configuration,
    - Select the testNG.xm, select Listener option and add below options.
        - EmailableReport
        - failedReport
 
 - Once the project is downloaded and configured, run mnv clean in terminal.
 
 # Configuration in config/config.properties files
 
    -  Place you device name as the value of the key name is "deviceId", device id will be your device which the user can find out from 
    about phone in phone setting.
    - Place device id  as the value of the key name "udid", to find the udid run the "Commond" adb device in the terminal.
    - Platform should be android as the framework and test cases design for Android.
    - Place you android version as the value of the key name is "paltformVersion", device id will be your device which
     the user can find out from about phone in phone setting.
    - Place the city name which you wanted to search and delect as the value of the key name "cityToSelect",
     upper & lower case both are allowed.
    - Place you mobile Number as the value of the key name is "mobileNumber", mobile number is required to perform login
     scenerio if app is asking for login.
    - Place you password as the value of the key name is "password", password is required to perform login
      scenerio if app is asking for login. Login with Otp is not implemented as of now.
    Note:- Please don not change any other value it will lead to fail the test cases.
    
 # Task Details are below:
    - Step 1 - Launch NoBroker App and Land on the Home Page. {Coved in verifyPermissionEnable()}.
    - Step 2 - Select ‘Buy’ property related option and Click on the ‘Search’ related box. {Coved in verifyBuyButtonTap()}.
    - Step 3 - From the next page select “Bangalore” city.{Coved in verifyBangaloreSelection()}.
    - Step 4 - Click on the Search Box bar and select two localities(Marathahalli and HSR Layout) from the Autosuggestion
     locality dropdown. {Coved in verifyBangaloreSelection()}.
    - Step 5 - Click on the checkbox “Include nearby Properties” (Note:: if checkbox is enabled then select either 
    step over 6).{Coved in verifySearchButton()}.
    - Step 6 - Select 2 Bhk and 3 Bhk from the number of bedrooms section. {Coved in verifySearchButton()}
    - Step 7 - Click on the Search related button.{Coved in verifySearchButton()}.
    - Step 8 - Scroll down on the Property listing page and click on the 4th property.{Coved in verifySearchButton()}.
    - Step 9- Scroll down to till end and click on “Wrong Info” which comes under ‘Report what was’t correct in this
     property’.{Coved in verifyScrollTillend()}.
    - Step 10- Select all check-boxes in “What’s wrong” section and click on Report .{Coved in verifyWhatsWrongOptions()}.
    - Step 11- Change 3BHK to 4+BHK from ‘whats is the correct configuration’ section in “Suggest an Edit” page.{Coved 
    in verifySuggetedAnEdit()}.
    - Step 12- click on the “save changes” button and verify the successful message “Thank you for the Feedback”.{Coved 
    in verifyFeedbackMessage()}.
    Note:- To run above test cases please run the testNG.xml.