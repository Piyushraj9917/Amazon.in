package PageObject;

import AbstractComponents.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class AnonymousUser extends AbstractClass {
    WebDriver driver;

    public AnonymousUser(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//input[@name='field-keywords']") WebElement GsearchField;
    @FindBy (css = ".nav-search-submit-text")WebElement Gsearch;
    @FindBy (xpath = "//*[contains(text(),'Samsung Galaxy S24 Ultra 5G AI Smartphone (Titanium Gray, 12GB, 256GB Storage)')]")
    WebElement SearchedItem;
    @FindBy(xpath = "//input[@id='buy-now-button']") WebElement AddToBuy;

    public void GuestSearch()
    {
        GsearchField.sendKeys("Samsung Galaxy S24 Ultra");
        Gsearch.click();
        SearchedItem.click();

       Set<String> Window = driver.getWindowHandles();
       Iterator<String> it = Window.iterator();
       String ParentWindow = it.next();
       String ChildWindow = it.next();
       driver.switchTo().window(ChildWindow);
    }
}
