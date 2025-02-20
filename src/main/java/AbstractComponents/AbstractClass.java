package AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;

import static Utils.DatabaseUtils.ExecuteQuery;

public class AbstractClass {
    static WebDriver driver;

    public AbstractClass(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".a-input-text")
    static WebElement MobileNumber;
    @FindBy(css = "input[class='a-button-input']")
    static WebElement Continue;
    @FindBy(id = "ap_password")
    static WebElement Password;
    @FindBy(id="signInSubmit")
    static WebElement SignIn;
    @FindBy(xpath ="//span[@class='a-list-item']") WebElement Error;

    @FindBy (css =".nav-line-1-container") static WebElement SignInHover;
    @FindBy(css = ".nav-action-signin-button") static WebElement SignInButton;

    public void WaitForElementToAppear(WebElement Element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

    public void LaunchAmazon()
    {
        driver.get("https://www.amazon.in/");
    }

    public void GoToLoginPage()
    {
        Actions action = new Actions(driver);
        action.moveToElement(SignInHover).build().perform();
        SignInButton.click();
    }

    public static void Login() throws SQLException, IOException {
        ArrayList AmazonDBdata = ExecuteQuery("select * from InvalidCred");
        String[] FirstRow = (String[]) AmazonDBdata.getFirst();
        MobileNumber.sendKeys(FirstRow[0]);
        Continue.click();
        Password.sendKeys(FirstRow[1]);
        SignIn.click();
    }
}
