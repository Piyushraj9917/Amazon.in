package PageObject;

import AbstractComponents.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NegativeSearch extends AbstractClass {
    WebDriver driver;

    public NegativeSearch(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "twotabsearchtextbox") WebElement SearchField;
    public void InvalidAmazonSearch()
    {
        SearchField.clear();
        SearchField.sendKeys("XYZ 123 Mobile");
    }
}
