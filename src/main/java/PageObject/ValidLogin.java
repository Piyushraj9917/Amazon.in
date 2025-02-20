/*
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
    }
 */
