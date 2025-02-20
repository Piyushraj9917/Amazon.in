package PageObject;

import AbstractComponents.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractClass {
    public WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
}
