/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Message;
import com.rentamaquina.maquinaria.app.repositories.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jandr
 */
@Service
public class MessageService {
    
    // Autowired para poderla implementar porque es un repositorio
    @Autowired
    private MessageRepository repository;
    
    /**
     * GET: Consultar todos los registros
     * @return 
     */
    public List<Message> getMessages(){
        return repository.findAll();
    }
    
    /**
     * POST Crear o registrar
     * @param message
     * @return 
     */
    public Message saveMessage(Message message){
        Message existingMessage = repository.findById(message.getId()).orElse(null);
        if(existingMessage==null){
           repository.save(message);
        }
        return message;
    }
    
    /**
     * PUT Actualizar o editar
     * @param message
     * @return 
     */
    public Message updateMessage(Message message){
        Message existingMessage = repository.findById(message.getId()).orElse(null);
        existingMessage.setMessagetext(message.getMessagetext());
        return repository.save(existingMessage);
    }
    
    /**
     * DELETE Eliminar registro
     * @param id
     * @return 
     */
    public String deleteMessage(Integer id){
        repository.deleteById(id);
        return "Mensaje eliminado "+id;
    }
    
}
