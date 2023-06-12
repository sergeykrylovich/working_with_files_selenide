package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ParseJsonWithJackson {

    @Test
    void parseJson () throws Exception {
        JsonFactory jsonF = new JsonFactory();

        try (
                JsonParser jp = jsonF.createJsonParser(new File("src/test/resources/examples/input.json"))
        ) {
//           while (jp.nextToken() != JsonToken.END_OBJECT) {
//               String fieldName = jp.getCurrentName();
//               System.out.println(fieldName);
//               System.out.println(jp.getText());
//               jp.nextToken();
//           }
            jp.getCurrentToken();
        }



    }
}
