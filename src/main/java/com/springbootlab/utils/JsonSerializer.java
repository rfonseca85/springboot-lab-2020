package com.springbootlab.utils;

import com.springbootlab.annotations.Init;
import com.springbootlab.annotations.JsonElement;
import com.springbootlab.annotations.JsonSerializable;
import com.springbootlab.exceptions.JsonSerializationException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializer {

    public String convertToJson(Object object) throws JsonSerializationException {
        try {
            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);
        }catch (Exception e){
            throw new JsonSerializationException(e.getMessage());
        }
    }

    private void checkIfSerializable(Object object) throws JsonSerializationException {
        if(Objects.isNull(object)){
            throw new JsonSerializationException("The object to serialize is null");
        }

        Class<?> clazz = object.getClass();
        if(!clazz.isAnnotationPresent(JsonSerializable.class)){
            throw new JsonSerializationException("The class "+ clazz.getSimpleName() + " is not annotated");
        }
    }

    private void initializeObject(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for(Method method : clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(Init.class)){
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String getJsonString(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Map<String, String> jsonElementMap = new HashMap<String, String>();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementMap.put(field.getName(), (String) field.get(object));
            }
        }

        String jsonString = jsonElementMap.entrySet().stream()
                .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(","));

        return "{" + jsonString + "}";
    }

}
