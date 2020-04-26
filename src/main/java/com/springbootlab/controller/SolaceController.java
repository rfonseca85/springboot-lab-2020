package com.springbootlab.controller;


import com.springbootlab.service.SolaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/solace")
public class SolaceController {

    @Autowired
    SolaceService solaceService;

    @PostMapping("/sendMessage/{topic}/{message}")
    public ResponseEntity<Boolean> sendSolaceMessage (@PathVariable String topic, @PathVariable String message) throws ResourceNotFoundException {
        try{
            solaceService.sendMessage(topic, message);
        }catch (Exception e){
            ResponseEntity.badRequest();
        }
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
