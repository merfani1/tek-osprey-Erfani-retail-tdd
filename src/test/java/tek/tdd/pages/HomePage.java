package tek.tdd.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utilities.SeleniumUtilities;

public class HomePage extends SeleniumUtilities {

    public HomePage(){
        PageFactory.initElements(getDriver(),this);
    }
    // driver.findElement(By.classname("classname")
    @FindBy(className = "top-nav__logo")
    public WebElement topNavLogo;

    @FindBy(id = "signinLink")
    public WebElement signInButton;

    @FindBy(id = "logoutBtn")
    public WebElement LogoutButton;
}
