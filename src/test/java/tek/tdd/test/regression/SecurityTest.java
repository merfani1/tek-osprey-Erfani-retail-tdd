package tek.tdd.test.regression;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.BaseUITests;
import tek.tdd.pages.HomePage;
import tek.tdd.pages.LoginPage;

public class SecurityTest extends BaseUITests {
    @DataProvider(name = "validCredentials")
    public String [][] validCredentialProvider(){
        String [][] data={
                {"tony1@gail.com","Tony@1234"},
                {"Mansoor@gmail.com","Ruya@2014"}
        };
        return data;
    }
    @Test(dataProvider = "validCredentials")
    public void validateLoginWithValidCredentials(String userName,String password){
        //Navigate to sign in page and sing in with valid username and password.
        //Validate user successfully signed in.
       // HomePage homePage=new HomePage();
        clickOnElement(homePage.signInButton);

       // LoginPage loginPage=new LoginPage();

       // sendText(loginPage.emailInput,userName);
       // sendText(loginPage.passwordInput,password);
        //clickOnElement(loginPage.LoginButton);

        loginPage.doLogin(userName,password);

        boolean isLogoutBtnDisplayed=isElementDisplayed(homePage.LogoutButton);
        Assert.assertTrue(isLogoutBtnDisplayed,
                "After Success login,Logout Button should display in home page");
    }
    @Test(dataProvider = "negativeTestData")
    public void validateLoginWithInvalidCredentials(
            String userName,
            String password,
            String expectedErrorMessage
    ){
        //HomePage homePage=new HomePage();
        clickOnElement(homePage.signInButton);

       // LoginPage loginPage=new LoginPage();

       // sendText(loginPage.emailInput,email);
       // sendText(loginPage.passwordInput,password);
       // clickOnElement(loginPage.LoginButton);
        loginPage.doLogin(userName,password);

       String actualErrorMessage= getElementText(loginPage.errorMessage);
       Assert.assertEquals(actualErrorMessage,expectedErrorMessage,
               "Error Message should display");
    }
    @DataProvider(name = "negativeTestData")
    private  String [][] negativeTestData(){
        String [][]data={
                {"Wrong@gmail.com","1234@Abe","wrong username or password"},
                {"tony1@gmail.com","Invalid@password","wrong username or password"},
                {"Wrong@gmail.com","invalid@1234","wrong username or password"}

        };
        return data;
    }

}
