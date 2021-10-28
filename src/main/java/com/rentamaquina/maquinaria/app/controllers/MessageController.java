/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Message;
import com.rentamaquina.maquinaria.app.services.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jandr
 */
@RestController
@RequestMapping("Message")
public class MessageController {
    
    @Autowired
    private MessageService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Message> getMessages(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param message
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public Message save(@RequestBody Message message){
        return service.save(message);
    }
    
    /**
     * PUT
     * @param message
     * @return 
     */
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public Message update(@RequestBody Message message){
        return service.update(message);
    }
    
    /**
     * DELETE
     * @param messageId
     * @return 
     */
    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public boolean delete(@PathVariable("id")int messageId){
        return service.deleteMessage(messageId);
    }
}