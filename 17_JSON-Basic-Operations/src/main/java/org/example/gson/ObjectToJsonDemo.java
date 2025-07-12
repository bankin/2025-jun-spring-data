package org.example.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectToJsonDemo {
    public static void main(String[] args) {
        //JAVA OBJECT INTO JSON (String)
        AddressDTO address = new AddressDTO("Bulgaria", "Sofia");
        PersonDTO person = new PersonDTO("Georgi",
                                          "Ivanov",
                                                24,
                                            true,
                                                    Date.from(Instant.now()),
                                                    address);
        person.setFriendsList(List.of("Ivan", "Pesho", "Mitko"));

        Gson gsonBuilder = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation() //показва само полета с анотация expose
                    .setPrettyPrinting() //формат, който е лесен за четене
                    .setDateFormat("dd-MM-YYY") //по какъв начин да се визуализират датите в json-a
                    .serializeNulls() //показваме и null стойностите
                    .create(); //създаваме builder за json-и, който има определени специфики

        String json = gsonBuilder.toJson(person);
        //System.out.println(json);

        //създаваме втори човек
        PersonDTO person2 = new PersonDTO("Desislava",
                "Topuzakova",
                27,
                false,
                Date.from(Instant.now()),
                address);
        person2.setFriendsList(List.of("Niki", "Tedi", "Marti"));

        //списък от обекти -> json
        List<PersonDTO> listPeople = new ArrayList<>();
        listPeople.add(person);
        listPeople.add(person2);

        String jsonList = gsonBuilder.toJson(listPeople);
        System.out.println(jsonList);

    }
}
