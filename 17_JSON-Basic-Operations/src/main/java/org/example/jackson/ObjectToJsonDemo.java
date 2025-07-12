package org.example.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJsonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        //JAVA OBJECT TO JSON
        PersonDTO person = new PersonDTO("Ivan", "Stoyanov", 34, true);

        ObjectMapper objectMapper = new ObjectMapper();
        //ObjectMapper е част от jackson-databind
        //ObjectMapper, за да работи използва JSONParser и JSONGenerator от jackson-core

        String json = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(person);
        System.out.println(json);

    }
}
