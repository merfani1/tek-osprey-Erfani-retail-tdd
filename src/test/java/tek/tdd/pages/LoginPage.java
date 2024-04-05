package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

import java.util.List;

public class LoginPage extends SeleniumUtilities {
    /*
    Initialize current session of Driver. to all the element of the page
     */

    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(name = "email")
    public WebElement emailInput;
    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(id = "loginBtn")
    public WebElement LoginButton;

    @FindBy(className = "error")
    public WebElement errorMessage;

    // if the locator return more than 1 Elements
    @FindBy(tagName = "a")
    public List<WebElement> anchorElements;

    public void doLogin(String userName, String password){
        sendText(emailInput,userName);
        sendText(passwordInput,password);
        clickOnElement(LoginButton);
    }

}
