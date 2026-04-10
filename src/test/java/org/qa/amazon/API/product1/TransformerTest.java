package org.qa.amazon.API.product1;

import org.qa.amazon.apipojo.inputs.product1.Transformer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TransformerTest extends Base {

    @BeforeMethod
    public void getResponse() {
        Objectma objectMapper = new ObjectMapper();

        Transformer  trans =   response.text()
    }

    @Test
    public void testTransformer_counterparty() {
        // Implement your test logic here
        System.out.println("Running TransformerTest for Product 1");
    }

    @Test
    public void testTransformer_entities() {
        // Implement your test logic here
        System.out.println("Running TransformerTest for Product 1");
    }

}
