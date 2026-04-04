package org.qa.amazon.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;

    private  String userName = "//input[@id='Email']";
    private String password = "//input[@id='Password']";
    private String loginBtn = "//button[text()='Log in']";

    public  LoginPage(Page page){
        this.page = page;
    }

    public void doLogin(String username, String pwd){
        page.locator(userName).fill(username);
        page.locator(password).fill(pwd);
        page.locator(loginBtn).click();
    }

     public String getLoginPageTitle(){
         return page.title();
     }

     public String getLoginPageURL(){
         return page.url();
     }

}
