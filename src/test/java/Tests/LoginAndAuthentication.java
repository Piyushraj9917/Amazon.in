package Tests;

import PageObject.ValidLogin;
import PageObject.SearchFeature;
import TestComponents.BaseTest;
import org.apache.commons.math3.analysis.function.Cos;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Utils.DatabaseUtils.ExecuteQuery;

public class LoginAndAuthentication extends BaseTest {
    ValidLogin LoginOBJ;
    SearchFeature search;

    @Test
    public void AmazonLogin() throws SQLException, IOException {
        lp.LaunchAmazon();
        LoginOBJ = lp.GoToLoginPage();
        search = LoginOBJ.ValidPassword();
    }

    @Test
    public void ProductSearch() throws SQLException, IOException {
        SoftAssert assertion = new SoftAssert();
        ArrayList VLogin = ExecuteQuery("select * from ValidLogin");
        String[] RowOne = (String[]) VLogin.getFirst();
        search.ValidProductSearch();
        List<String> NamesList= search.GetProductNames();
        for(String Names : NamesList)
        {
            Boolean IsRelevant = Names.toLowerCase().contains(RowOne[2]);
           // System.out.println(RowOne[2]);
            assertion.assertTrue(IsRelevant,"Unrelated Product found :"+ Names);
        }
        List<String> PriceList = search.ItemCost();
        for(String Cost : PriceList) {
            Boolean Pricing = (Cost == null || Cost.isEmpty());
            assertion.assertFalse(Pricing);
        }
        List<String> iphoneRatingList = search.ItemsRating();
        for(String IndividualiphoneRating : iphoneRatingList)
        {
                Boolean IsRatingAvailable = (IndividualiphoneRating == null || IndividualiphoneRating.isEmpty());
            assertion.assertFalse(IsRatingAvailable);
        }

        List<String> AvailabilityList = search.Availability();
        for(String IphoneAvailable : AvailabilityList)
        {
            assertion.assertFalse(IphoneAvailable.isEmpty());
        }
        assertion.assertAll();
    }
}
