package org.example.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToObjectDemo {
    public static void main(String[] args) throws JsonProcessingException {
        //JSON към JAVA OBJECT
        String json = "{\n" +
                "  \"firstName\" : \"Ivan\",\n" +
                "  \"lastName\" : \"Stoyanov\",\n" +
                "  \"age\" : 34,\n" +
                "  \"married\" : true\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        PersonDTO person = objectMapper.readValue(json, PersonDTO.class);
        System.out.println(person);

    }
}
