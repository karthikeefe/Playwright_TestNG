package org.qa.amazon.API.product2;

import com.google.gson.Gson;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.qa.amazon.API.BaseTest;
import org.qa.amazon.apipojo.inputs.APIInputs;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class Base extends BaseTest {
    APIResponse response;


    @BeforeClass
    public void product1Setup() throws FileNotFoundException {
        Gson gson = new Gson();
        APIInputs input = gson.fromJson(new FileReader(System.getProperty("user.dir") + "/src/test/java/org/qa/amazon/apipojo/inputs/product1.json"), APIInputs.class);
        response = context.post(prop.getProperty("APIURL"), RequestOptions.create()
                .setHeader("Content-Type", "application/json")
                .setData(input));
    }

    @AfterTest
    public void product1TearDown() {
        response.dispose();
    }
}
