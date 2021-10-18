/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Machine;
import com.rentamaquina.maquinaria.app.repositories.MachineRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jandr
 */
@Service
public class MachineService {
    
    // Autowired para poderla implementar porque es un repositorio
    @Autowired
    private MachineRepository repository;
    
    /**
     * GET: Consultar todos los registros
     * @return 
     */
    public List<Machine> getMachines(){
        return repository.findAll();
    }
    
    /**
     * POST Crear o registrar
     * @param machine
     * @return 
     */
    public Machine saveMachine(Machine machine){
        Machine existingMachine = repository.findById(machine.getId()).orElse(null);
        if(existingMachine==null){
           repository.save(machine);
        }
        return machine;
    }
    
    /**
     * PUT Actualizar o editar
     * @param machine
     * @return 
     */
    public Machine updateMachine(Machine machine){
        Machine existingMachine = repository.findById(machine.getId()).orElse(null);
        existingMachine.setName(machine.getName());
        existingMachine.setBrand(machine.getBrand());
        existingMachine.setModel(machine.getModel());
        existingMachine.setCategoryId(machine.getCategoryId());
        return repository.save(existingMachine);
    }
    
    /**
     * DELETE Eliminar registro
     * @param id
     * @return 
     */
    public String deleteMachine(Integer id){
        repository.deleteById(id);
        return "Maquina eliminada "+id;
    }

}
