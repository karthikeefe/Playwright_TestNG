package org.qa.amazon.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.util.Properties;


public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    Properties prop;


    public Page initBrowser(String browserName){

        playwright = Playwright.create();

        switch(browserName.toLowerCase()){
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                System.out.println("Please pass the browser name as :chromium or firefox");
                break;
        }

        context = browser.newContext();
        page = context.newPage();
        page.navigate(prop.getProperty("url").trim());

        return page;

    }

    public Properties init_properties(){
        try{
            FileInputStream fileip = new FileInputStream("C:\\Users\\karth\\IdeaProjects\\Playwright\\src\\test\\resources\\config.properties");
            prop = new Properties();
            prop.load(fileip);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return prop;
    }
}
