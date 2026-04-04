package org.qa.amazon.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    //1. constructor of the page class
    private Page page;

    public  HomePage(Page page){
        this.page = page;
    }

    //2. page locators
    private String login = "//a[text()='Log in']";

    //3. page actions
    public String pageTitle(){
        return page.title();
    }

    public  String pageURL(){
        return page.url();
    }

    public LoginPage navigatetoLoginPage(){
        page.click(login);
        return new LoginPage(page);
    }


}
