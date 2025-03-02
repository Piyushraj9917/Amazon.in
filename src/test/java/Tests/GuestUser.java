package Tests;

import PageObject.AnonymousUser;
import TestComponents.BaseTest;
import org.testng.annotations.Test;

public class GuestUser extends BaseTest {

        @Test
        public void GuestLaunch()
        {
                lp.LaunchAmazon();
        }

        @Test
        public void GuestCartAndCheckout()
        {
                AnonymousUser Au = new AnonymousUser(driver);
                Au.GuestSearch();
        }



}
