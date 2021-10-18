/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Client;
import com.rentamaquina.maquinaria.app.repositories.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jandr
 */
@Service
public class ClientService {
    
    // Autowired para poderla implementar porque es un repositorio
    @Autowired
    private ClientRepository repository;
    
    /**
     * GET: Consultar todos los registros
     * @return 
     */
    public List<Client> getClients(){
        return repository.findAll();
    }
    
    /**
     * POST Crear o registrar
     * @param machine
     * @return 
     */
    public Client saveClient(Client client){
        Client existingClient = repository.findById(client.getId()).orElse(null);
        if(existingClient==null){
           repository.save(client);
        }
        return client;
    }
    
    /**
     * PUT Actualizar o editar
     * @param machine
     * @return 
     */
    public Client updateClient(Client client){
        Client existingClient = repository.findById(client.getId()).orElse(null);
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        existingClient.setPassword(client.getPassword());
        return repository.save(existingClient);
    }
    
    /**
     * DELETE Eliminar registro
     * @param id
     * @return 
     */
    public String deleteClient(Integer id){
        repository.deleteById(id);
        return "Cliente eliminada "+id;
    }
}
