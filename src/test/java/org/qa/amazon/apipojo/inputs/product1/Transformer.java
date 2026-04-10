package org.qa.amazon.apipojo.inputs.product1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Transformer {

    public String name;
    public String type;


}
