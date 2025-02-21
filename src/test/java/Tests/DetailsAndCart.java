package Tests;

import AbstractComponents.AbstractClass;
import PageObject.ProductDetails;

import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

public class DetailsAndCart extends BaseTest {
    ProductDetails pd;

    @Test
    public void LoginforDetailAndCart() throws SQLException, IOException {
        lp.LaunchAmazon();
        lp.GoToLoginPage();
        AbstractClass.Login();
    }
    @Test
    public void Validation() throws SQLException, IOException {
        pd = new ProductDetails(driver);
        pd.ProductPage();
        String IphoneTitle = pd.ProductTitleValidation();
        Assert.assertEquals(IphoneTitle, "Apple iPhone 13 (128GB) - Midnight");
        String SplitPrice = pd.PriceValidation();
        Assert.assertEquals(SplitPrice, "43,499");

        String VerifyText = pd.RatingValidation();
        Assert.assertEquals(VerifyText,"4.5 out of 5 stars");

        Assert.assertTrue(pd.CartButtonAvailable());
        pd.AddToCart();
    }
}
