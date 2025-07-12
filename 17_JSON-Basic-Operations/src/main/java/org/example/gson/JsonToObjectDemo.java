package org.example.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonToObjectDemo {
    public static void main(String[] args) {
        //JSON to JAVA OBJECT
        String json = "\n" +
                "{\n" +
                "  \"firstName\": \"Georgi\",\n" +
                "  \"lastName\": \"Ivanov\",\n" +
                "  \"age\": 24,\n" +
                "  \"birthday\": \"11-07-2025\",\n" +
                "  \"address\": {\n" +
                "    \"country\": \"Bulgaria\",\n" +
                "    \"city\": \"Sofia\"\n" +
                "  },\n" +
                "  \"friendsList\": [\n" +
                "    \"Ivan\",\n" +
                "    \"Pesho\",\n" +
                "    \"Mitko\"\n" +
                "  ]\n" +
                "}";

        Gson gsonBuilder = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation() //показва само полета с анотация expose
                .setPrettyPrinting() //формат, който е лесен за четене
                .setDateFormat("dd-MM-YYY") //по какъв начин да се визуализират датите в json-a
                .serializeNulls() //показваме и null стойностите
                .create(); //създавам

        PersonDTO person = gsonBuilder.fromJson(json, PersonDTO.class);
       // System.out.println(person);


        //json -> списък с обекти
        String jsonObjects = "[\n" +
                "  {\n" +
                "    \"firstName\": \"Georgi\",\n" +
                "    \"lastName\": \"Ivanov\",\n" +
                "    \"age\": 24,\n" +
                "    \"birthday\": \"11-07-2025\",\n" +
                "    \"address\": {\n" +
                "      \"country\": \"Bulgaria\",\n" +
                "      \"city\": \"Sofia\"\n" +
                "    },\n" +
                "    \"friendsList\": [\n" +
                "      \"Ivan\",\n" +
                "      \"Pesho\",\n" +
                "      \"Mitko\"\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"firstName\": \"Desislava\",\n" +
                "    \"lastName\": \"Topuzakova\",\n" +
                "    \"age\": 27,\n" +
                "    \"birthday\": \"11-07-2025\",\n" +
                "    \"address\": {\n" +
                "      \"country\": \"Bulgaria\",\n" +
                "      \"city\": \"Sofia\"\n" +
                "    },\n" +
                "    \"friendsList\": [\n" +
                "      \"Niki\",\n" +
                "      \"Tedi\",\n" +
                "      \"Marti\"\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        PersonDTO[] peopleArray = gsonBuilder.fromJson(jsonObjects, PersonDTO[].class);
        System.out.println(peopleArray[0]);
        System.out.println(peopleArray[1]);
    }
}
