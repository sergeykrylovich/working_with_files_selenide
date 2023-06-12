package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.object.JsonEmployee;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ParseJsonWithJackson {
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void parseJson () throws Exception {
        File file = new File("src/test/resources/examples/input.json");

        List<JsonEmployee> employee = objectMapper.readValue(file, new TypeReference<>() {});
        assertThat(employee.get(0).getAge()).isEqualTo(33);
        assertThat(employee.get(0).getFirstName()).isEqualTo("Marge");
        assertThat(employee.get(0).getLastName()).isEqualTo("Simpson");
        assertThat(employee.get(0).getComputer().get(0).getRam()).isEqualTo("DDR3");



    }
}
