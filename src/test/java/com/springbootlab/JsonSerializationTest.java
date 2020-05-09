package com.springbootlab;

import com.springbootlab.exceptions.JsonSerializationException;
import com.springbootlab.model.JsonTestPerson;
import com.springbootlab.utils.JsonSerializer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonSerializationTest {

    private static final Logger log = LoggerFactory.getLogger(JsonSerializationTest.class);

    @Test
    public void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
        JsonTestPerson person = new JsonTestPerson("Rafael", "Fonseca", "35", "Test Address");
        JsonSerializer serializer = new JsonSerializer();
        String jsonString = serializer.convertToJson(person);
        assertEquals("{\"firstName\":\"Rafael\",\"lastName\":\"Fonseca\",\"address\":\"Test Address\",\"age\":\"35\"}",
                jsonString);
    }

}