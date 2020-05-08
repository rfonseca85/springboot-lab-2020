package com.springbootlab.utils;

import com.springbootlab.model.Client;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {

    public static void main(String[]args){

        List<Client> clients= Arrays.asList(new Client("" +
                        "Rafael","Fonseca")
                ,new Client("Ana Gabriela","Lopes")
                ,new Client("Amora","Lopes Fonseca"));


        //Returning as collection.toList after filter
        clients = clients.stream()
                .filter(f -> f.getName().startsWith("R"))
                .filter(f -> f.getLastName().startsWith("F"))
                .collect(Collectors.toList());

        //Simple foreach on a stream.... foreach is the latest one
        clients.stream().forEach(s -> {
            System.out.println(s.getName());
        });

        //types return.. like count
        Long count = clients.stream().count();

        //skipping 3 first lines
        clients = (List<Client>) clients.stream()
                .skip(3)
                .limit(5)
                .collect(Collectors.toList());

    }

}
