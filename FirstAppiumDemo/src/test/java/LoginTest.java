import Pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import CommonSteps.CommonSteps;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {
    AppiumDriver driver;
    LoginPage loginPage;
    CommonSteps commonSteps;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName" , "UiAutomator2");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage", "com.gdg.lgfm");
        caps.setCapability("appActivity", ".MainActivity");
//        caps.setCapability("app", System.getProperty("user.dir")+"/apps/2022-03-15-app-rel-01.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }
    @Test
    public void ValidLoginTest() throws MalformedURLException, InterruptedException {
                loginPage = new LoginPage(driver);
                commonSteps = new CommonSteps(driver);
                commonSteps.skipOnboarding();
                commonSteps.denyLocation();
                commonSteps.acceptDenyLocation();
                commonSteps.Wait();
                commonSteps.closeLocationPopup();
                commonSteps.clickProfileButton();
                loginPage.clickEmailInputField();
                loginPage.enterEmail();
    }

    @Test
    public void InvalidLoginTest() throws MalformedURLException, InterruptedException {
        loginPage = new LoginPage(driver);
        commonSteps = new CommonSteps(driver);
        commonSteps.skipOnboarding();
        commonSteps.denyLocation();
        commonSteps.acceptDenyLocation();
        commonSteps.Wait();
        commonSteps.closeLocationPopup();
        commonSteps.clickProfileButton();
    }

    @AfterMethod
    public void tearDown(){
        if (null !=driver){
            driver.quit();
        }
    }
}
