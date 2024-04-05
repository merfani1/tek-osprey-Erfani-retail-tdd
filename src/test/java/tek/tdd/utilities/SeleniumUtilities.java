package tek.tdd.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.tdd.base.BaseSetup;

import java.time.Duration;

public class SeleniumUtilities extends BaseSetup {
    public static final Logger LOGGER= LogManager.getLogger(SeleniumUtilities.class);
    public WebDriverWait getWait(){
        return new WebDriverWait(getDriver(),Duration.ofSeconds(20));
    }
    public WebElement waitForVisibility(WebElement element){
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element){
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    // Click
    public void clickOnElement(WebElement element){
        LOGGER.info("Click on Element {}",element);
        waitForClickable(element).click();
    }
    // SendKey
    public void sendText(WebElement element, String textValue){
        LOGGER.info("Send key to Element {} with Value{}",element,textValue);
        waitForVisibility(element).sendKeys(textValue);
    }
    //isDisplayed
    public boolean isElementDisplayed(WebElement element){
        LOGGER.info("Checking Element is Displayed {}",element);
        return waitForVisibility(element).isDisplayed();
    }
    // isEnabled
    public boolean isElementEnabled(WebElement element){
        LOGGER.info("Checking Element is Enabled"+element);
        return waitForVisibility(element).isEnabled();
    }
    // getText
    public String  getElementText(WebElement element){
        LOGGER.info("Getting Element text"+element);
        return waitForVisibility(element).getText();
    }

    // Select text from drop down list
    public void selectFromDropDown(WebElement element,String visibleText){
        WebElement selectElement=waitForVisibility(element);
        Select select=new Select(selectElement);
        select.selectByVisibleText(visibleText);
    }
}
