    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Client;
import com.rentamaquina.maquinaria.app.services.ClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jandr
 */
@RestController
@RequestMapping("Client")
@CrossOrigin(origins = "*")
public class ClientController {
    
    @Autowired
    private ClientService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Client> getClients(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param client
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public Client save(@RequestBody Client client){
        return service.save(client);
    }
    
    /**
     * PUT
     * @param client
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public Client update(@RequestBody Client client){
        return service.update(client);
    }
    
    /**
     * DELETE
     * @param clientId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //Anotacion que retorna el status
    public boolean delete(@PathVariable("id")int clientId){
        return service.deleteClient(clientId);
    }
}

