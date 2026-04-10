package org.qa.amazon.API;

import com.microsoft.playwright.APIRequestContext;
import org.qa.amazon.factory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    static PlaywrightFactory pfAPI;
    public static Properties prop;
    public APIRequestContext context;

    @BeforeTest
    public void setup() {
        pfAPI = new PlaywrightFactory();
        prop = pfAPI.init_properties();
        context = pfAPI.initAPI();

    }

    @AfterTest
    public void tearDown() {
        pfAPI.getPlaywright().close();
    }
}
