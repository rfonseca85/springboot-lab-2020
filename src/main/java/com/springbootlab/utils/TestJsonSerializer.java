package com.springbootlab.utils;

import com.springbootlab.exceptions.JsonSerializationException;
import com.springbootlab.model.JsonTestPerson;

public class TestJsonSerializer {

    public static void main(String[] args) throws JsonSerializationException {
        JsonTestPerson person = new JsonTestPerson("Rafael", "Fonseca", "35", "Test Address");
        JsonSerializer serializer = new JsonSerializer();
        String jsonString = serializer.convertToJson(person);

        System.out.println(jsonString);

    }

}
