/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.repositories;

import com.rentamaquina.maquinaria.app.repositories.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.rentamaquina.maquinaria.app.entities.Administration;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jandr
 */
@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    
    /**
     * GET - Consultar todos
     * @return 
     */
    public List<Administration> getAll(){
        return (List<Administration>) adminCrudRepository.findAll();
    }
    
    /**
     * INSERT
     * @param admin
     * @return 
     */
    public Administration save(Administration admin){
        return adminCrudRepository.save(admin);
    }
    
    /**
     * Buscar registro
     * @param adminId
     * @return 
     */
    public Optional<Administration> getAdmin(int adminId){
        return adminCrudRepository.findById(adminId);
    }
    
    /**
     * DELETE
     * @param admin 
     */
    public void delete(Administration admin){
        adminCrudRepository.delete(admin);
    }
}

