package com.springbootlab.controller;

import com.springbootlab.dao.ClientRepository;
import com.springbootlab.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getClients() throws ResourceNotFoundException {
        return ResponseEntity.ok().body(clientRepository.findAll());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) throws ResourceNotFoundException{
        return ResponseEntity.ok().body(clientRepository.getOne(id));
    }

    @PostMapping("/clients")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id,
                                               @RequestBody Client clientDetails) throws ResourceNotFoundException {
        Client clientUpdated = clientRepository.getOne(id);
        clientUpdated.setId(clientDetails.getId());
        clientUpdated.setName(clientDetails.getName());
        clientUpdated.setLastName(clientDetails.getLastName());
        return ResponseEntity.ok(clientRepository.save(clientUpdated));
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteClientById (@PathVariable Long id) throws ResourceNotFoundException{
        clientRepository.delete(clientRepository.findById(id).orElse(null));
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}











