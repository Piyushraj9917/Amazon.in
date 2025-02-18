package PageObject;

import AbstractComponents.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static Utils.DatabaseUtils.ExecuteQuery;

public class ValidLogin extends AbstractClass {
    WebDriver driver;

    public ValidLogin(WebDriver driver) {
        super(driver);
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".a-input-text") private WebElement MobileNumber;
    @FindBy(css = "input[class='a-button-input']") WebElement Continue;
    @FindBy(id = "ap_password") WebElement Password;
    @FindBy(id="signInSubmit") WebElement SignIn;
    @FindBy(xpath ="//span[@class='a-list-item']") WebElement Error;

    public PositiveSearch ValidPassword() throws SQLException, IOException {
        ArrayList AmazonDBdata = ExecuteQuery("select * from InvalidCred");
        //WaitForElementToAppear(MobileNumber);
        String[] FirstRow = (String[]) AmazonDBdata.getFirst();
        MobileNumber.sendKeys(FirstRow[0]);
        Continue.click();
        Password.sendKeys(FirstRow[1]);
        SignIn.click();
        return new PositiveSearch(driver);
    }
    /*
    @FindBy(css =".a-link-normal") WebElement BackToEmailField;
    @FindBy(css = ".a-input-text") private WebElement Email;
    public void InvalidEmail() throws SQLException, IOException {
        ArrayList invalidEmailData = ExecuteQuery("select * from InvalidCred");
        String[] SecondRow = (String[]) invalidEmailData.get(1);
        BackToEmailField.click();
        Email.clear();
        Email.sendKeys(SecondRow[0]);
        Continue.click();
        Password.sendKeys(SecondRow[1]);
        SignIn.click();
        BackToEmailField.click();
    }
    public SearchFeature ValidLogin() throws SQLException, IOException {
        ArrayList ValidLogin = ExecuteQuery("select * from ValidLogin");
        String[] VFirstRow = (String[]) ValidLogin.getFirst();
        //MobileNumber.clear();
        MobileNumber.sendKeys(VFirstRow[0]);
        Continue.click();
        Password.sendKeys(VFirstRow[1]);
        SignIn.click();
        return new SearchFeature(driver);
    }
     */
}
