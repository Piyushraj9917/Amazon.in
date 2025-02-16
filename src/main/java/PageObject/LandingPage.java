package PageObject;

import AbstractComponents.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractClass {
    public WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    public void LaunchAmazon()
    {
        driver.get("https://www.amazon.in/");
    }

    @FindBy (css =".nav-line-1-container") WebElement SignInHover;
    @FindBy(css = ".nav-action-signin-button") WebElement SignIn;
    public ValidLogin GoToLoginPage()
    {
        Actions action = new Actions(driver);
        action.moveToElement(SignInHover).build().perform();
        SignIn.click();
       //ValidLogin LoginOBJ = new ValidLogin(driver);
        return new ValidLogin(driver);
    }

}
