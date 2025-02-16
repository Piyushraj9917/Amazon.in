package PageObject;
import AbstractComponents.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Utils.DatabaseUtils.ExecuteQuery;
public class SearchFeature extends AbstractClass {
    public WebDriver driver;

    public SearchFeature(WebDriver driver) throws SQLException, IOException {
        super(driver);
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "twotabsearchtextbox") WebElement SearchField;
    @FindBy(css = "input[id='nav-search-submit-button']") WebElement SearchButton;
    @FindBy(xpath = "//a[h2[not(contains(., 'Sponsored'))]]/h2/span") List<WebElement> IphoneTitleMatch;
    @FindBy(css = ".a-price-whole") List<WebElement> IphonePrices;
    @FindBy(xpath ="//span[contains(text(),'out of 5 stars')]")List<WebElement> Rating;
    @FindBy(xpath = "//span[contains(text(),'Currently unavailable')]") List<WebElement> Availability;

    public void ValidProductSearch() throws SQLException, IOException
    {
        ArrayList ValidLogin = ExecuteQuery("select * from ValidLogin");
        String[] RowOne = (String[]) ValidLogin.getFirst();
        SearchField.sendKeys(RowOne[2]);
        SearchButton.click();
    }
    public List<String> GetProductNames()
    {
        List<String> Products = new ArrayList<>();
        for(WebElement item : IphoneTitleMatch)
        {
            Products.add(item.getText());
        }
        return Products;
    }
    public List<String> ItemCost()
    {
        List<String> PriceList = new ArrayList<>();
        for(WebElement price : IphonePrices)
        {
            PriceList.add(price.getText());
        }
        return PriceList;
    }
    public List<String> ItemsRating()
    {
        List<String> RatingList = new ArrayList<>();
        for(WebElement ElementRating : Rating)
        {
            RatingList.add(ElementRating.getAttribute("innerText").trim());
        }
        return RatingList;
    }
    public List<String> Availability()
    {
        List<String> AvailableIphoneList = new ArrayList<>();
        for(WebElement DeviceAvailable : Availability)
        {
            AvailableIphoneList.add(DeviceAvailable.getText());
        }
        return AvailableIphoneList;
    }
}
