/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Administration;
import com.rentamaquina.maquinaria.app.services.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("Admin")
@CrossOrigin(origins = "*")
public class AdminController {
    
    @Autowired
    private AdminService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Administration> getAdmins(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param admin
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public Administration save(@RequestBody Administration admin){
        return service.save(admin);
    }
    
    /**
     * PUT
     * @param admin
     * @return 
     */
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public Administration update(@RequestBody Administration admin){
        return service.update(admin);
    }
    
    /**
     * DELETE
     * @param adminId
     * @return 
     */
    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public boolean delete(@PathVariable("id")int adminId){
        return service.deleteAdmin(adminId);
    }
}
