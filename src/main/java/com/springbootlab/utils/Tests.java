package com.springbootlab.utils;

import com.springbootlab.model.JsonTestPerson;
import org.hibernate.type.SerializationException;

public class Tests {

    public static void main(String[] args) throws SerializationException {
        JsonTestPerson person = new JsonTestPerson("Rafael", "Fonseca", "35", "Test Address");
        JsonSerializer serializer = new JsonSerializer();
//        String jsonString = serializer.convertToJson(person);

        System.out.println(person);



    }

}
