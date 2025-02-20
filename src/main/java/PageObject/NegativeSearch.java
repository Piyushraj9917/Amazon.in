package PageObject;

import AbstractComponents.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class NegativeSearch extends AbstractClass {
    WebDriver driver;

    public NegativeSearch(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "twotabsearchtextbox") WebElement SearchField;
    @FindBy(css = "input[id='nav-search-submit-button']") WebElement SearchButton;
    @FindBy(xpath = "//div[@data-cy='title-recipe']/a") List<WebElement> XYZsearchedNames;
    public NegativeSearch InvalidAmazonSearch()
    {
        SearchField.clear();
        SearchField.sendKeys("XYZ 123");
        SearchButton.click();
        return new NegativeSearch(driver);
    }
    public List<String> AlternateElementsName()
    {
        List<String> AltElements = new ArrayList();
        for(WebElement Element : XYZsearchedNames)
        {
            AltElements.add(Element.getText());
        }
        return AltElements;
    }
}
