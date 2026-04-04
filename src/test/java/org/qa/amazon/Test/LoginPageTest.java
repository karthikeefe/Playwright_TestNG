package org.qa.amazon.Test;

import org.qa.amazon.Utils.ScreenshotOnFailureListener;
import org.qa.amazon.APPConstants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotOnFailureListener.class)
public class LoginPageTest extends BaseTest {

    @Test
    public void verifyLoginPageTitle(){
        loginPage = homePage.navigatetoLoginPage();
        String title = loginPage.getLoginPageTitle();
        System.out.println("Login page title is :"+ title);
        Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
    }
}
