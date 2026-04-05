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

    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();

    public Playwright getPlaywright(){
        return tlPlaywright.get();
    }
    public Browser getBrowser() {
        return tlBrowser.get();
    }
    public BrowserContext getContext() {
        return tlContext.get();
    }
    public Page getPage() {
        return tlPage.get();
    }

    public Page initBrowser(String browserName){

        tlPlaywright.set(Playwright.create());

        switch(browserName.toLowerCase()){
            case "chrome":
                //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            case "firefox":
                //browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
                break;
            default:
                System.out.println("Please pass the browser name as :chromium or firefox");
                break;
        }

        //context = browser.newContext();
        //page = context.newPage();
       // page.navigate(prop.getProperty("url").trim());

        tlContext.set(getBrowser().newContext());
        tlPage.set(getContext().newPage());
        getPage().navigate(prop.getProperty("url").trim());

        return getPage();

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
