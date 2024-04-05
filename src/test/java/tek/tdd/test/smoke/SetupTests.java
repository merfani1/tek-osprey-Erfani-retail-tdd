package tek.tdd.test.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;
import tek.tdd.pages.HomePage;
import tek.tdd.utilities.SeleniumUtilities;

public class SetupTests extends BaseUITests {


    @Test
    public void testRetailLogo() {

       // HomePage homePage = new HomePage();
        boolean isDisplayed = isElementDisplayed(homePage.topNavLogo);
        Assert.assertTrue(isDisplayed,"Top left corner logo should displayed always");

    }
    @Test
    public void validateLoginButtonIsEnabled(){
        // Navigate to retail app and make sure Sign in button is enabled
        //HomePage homePage=new HomePage();
        boolean isSignInButtonEnabled=isElementEnabled(homePage.signInButton);
        Assert.assertTrue(isSignInButtonEnabled,"Sign in button should be enabled all the time");
    }


}
