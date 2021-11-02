/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Score;
import com.rentamaquina.maquinaria.app.services.ScoreService;
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
@RequestMapping("Score")
@CrossOrigin(origins = "*")
public class ScoreController {
    
    @Autowired
    private ScoreService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Score> getScores(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param score
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public Score save(@RequestBody Score score){
        return service.save(score);
    }
    
    /**
     * PUT
     * @param score
     * @return 
     */
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public Score update(@RequestBody Score score){
        return service.update(score);
    }
    
    /**
     * DELETE
     * @param scoreId
     * @return 
     */
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public boolean delete(@PathVariable("id")int scoreId){
        return service.deleteScore(scoreId);
    }
}
