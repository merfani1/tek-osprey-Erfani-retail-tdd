package tek.tdd.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginPage;
import tek.tdd.utilities.SeleniumUtilities;
@Listeners({ExtentITestListenerAdapter.class})
public class BaseUITests extends SeleniumUtilities {

    public HomePage homePage;
    public LoginPage loginPage;
    @BeforeMethod
    public void initiateTestMethod(){

        super.openBrowser();
        // Pages need initialized driver so after opening browser we Create Objects.
        homePage=new HomePage();
        loginPage=new LoginPage();
    }

    @AfterMethod
    public void endTestMethod(ITestResult result){
        // ToDo add Screenshots
        if (result.getStatus()==ITestResult.FAILURE){
            TakesScreenshot takesScreenshot=(TakesScreenshot) getDriver();
            String screenshot=takesScreenshot.getScreenshotAs(OutputType.BASE64);

            ExtentTestManager.getTest().fail("Test failed Taking Screen Shot",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
        }
        super.quitBrowser();
    }

}
