package org.qa.amazon.Utils;

import com.microsoft.playwright.Page;
import org.qa.amazon.Test.*;

import java.nio.file.Paths;

public class ScreenshotOnFailureListener extends BaseTest implements org.testng.ITestListener {

    @Override
    public void onTestFailure(org.testng.ITestResult result) {
        Object currentClass = result.getInstance();

        try {
            if(page != null) {
                page.screenshot(new Page.ScreenshotOptions()
                        .setPath(Paths.get("src/test/resources/Screenshots/Error" + result.getName() + "-failed.png")).setFullPage(true));
                System.out.println("Captured screenshot for failed test: " + result.getName());
            }
        } catch (Exception e) {
            System.out.println("Error capturing failure screenshot: " + e.getMessage());
        }
    }


}
