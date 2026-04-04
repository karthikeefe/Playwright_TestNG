package org.qa.amazon.Test;

import com.microsoft.playwright.Page;
import org.qa.amazon.factory.PlaywrightFactory;
import org.qa.amazon.pages.HomePage;
import org.qa.amazon.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    // share browser and page across all test-class instances within the same <test> tag
    protected static PlaywrightFactory pf;
    protected static Page page;
    protected static HomePage homePage;
    protected static LoginPage loginPage;

    @BeforeTest
    public void setup(){
         pf = new PlaywrightFactory();
         String browserName = pf.init_properties().getProperty("browser").trim();
         page = pf.initBrowser(browserName);
         // initialize HomePage once here so it's available to all test classes in the same <test>
         homePage = new HomePage(page);
     }

    @AfterTest
    public void TearDown(){
         //page.context().browser().close();
     }
}
