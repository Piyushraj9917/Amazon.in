package Tests;

import AbstractComponents.AbstractClass;
import PageObject.NegativeSearch;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvalidCase extends BaseTest {
    NegativeSearch nsearch;
    String text = "XYZ 123";

    @Test
    public void LoginforInvalidCase() throws SQLException, IOException {
        lp.LaunchAmazon();
        lp.GoToLoginPage();
        AbstractClass.Login();
    }

    @Test
    public void InvalidProductSearch() throws SQLException, IOException {
        NegativeSearch ns = new NegativeSearch(driver);
        nsearch = ns.InvalidAmazonSearch();
        List<String> InvalidSuggestions = nsearch.AlternateElementsName();
        for(String InvalidElement : InvalidSuggestions)
        {
            Boolean IsContain = InvalidElement.contains(text);
            Assert.assertTrue(IsContain,"Invalid Product Found : "+text);
        }
    }
}
