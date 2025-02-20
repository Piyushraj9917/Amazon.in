package PageObject;

import AbstractComponents.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class ProductDetails extends AbstractClass {

    WebDriver driver;

    public ProductDetails(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "twotabsearchtextbox") WebElement SearchField;
    @FindBy(css = "input[id='nav-search-submit-button']") WebElement SearchButton;
    @FindBy(css = "div.a-section.aok-relative.s-image-fixed-height") WebElement Product;
    @FindBy(id = "productTitle") WebElement ProductTitle;
    @FindBy(css = ".a-price.aok-align-center.reinventPricePriceToPayMargin.priceToPay") WebElement iPhonePrice;
    @FindBy(css = ".a-icon.a-icon-star.a-star-4-5.cm-cr-review-stars-spacing-big span") WebElement iPhoneRating;
    @FindBy(xpath = "//input[@id='add-to-cart-button' and @value='Add to cart']") WebElement AddToCart;

    public void ProductPage()
    {
        SearchField.clear();
        SearchField.sendKeys("Apple Iphone 13");
        SearchButton.click();
        Product.click();
        Set<String> Window = driver.getWindowHandles();
        Iterator<String> it = Window.iterator();
        String ParentWindow = it.next();
        String ChildWindow = it.next();
        driver.switchTo().window(ChildWindow);
    }
    public String ProductTitleValidation()
    {
        String IphoneTitle = ProductTitle.getText();
        return IphoneTitle;
    }
    public String PriceValidation()
    {
        String Price = iPhonePrice.getText();
        String[] SplitArray = Price.split("\\u20B9");
        String SplitPrice = SplitArray[1];
        return SplitPrice;

    }
    public String RatingValidation()
    {
        String RatingText = iPhoneRating.getText();
        return RatingText;
    }
    public Boolean CartButtonAvailable()
    {
        Boolean CartButtonVisible = AddToCart.isDisplayed();
        return CartButtonVisible;
    }
    public void AddToCart()
    {
        AddToCart.click();
    }
}