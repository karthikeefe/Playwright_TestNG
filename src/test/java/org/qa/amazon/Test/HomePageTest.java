package org.qa.amazon.Test;

import org.qa.amazon.Utils.ScreenshotOnFailureListener;
import org.qa.amazon.APPConstants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotOnFailureListener.class)
public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageTitle(){
        String title = homePage.pageTitle();
        System.out.println("Home page title is :"+ title);
        Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
    }

    @Test
    public void verifyURL(){
        String url = page.url();
        System.out.println("Home page URL is :"+ url);
        Assert.assertEquals(url, AppConstants.HOME_PAGE_URL);
    }


}
