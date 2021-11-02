/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Reservation;
import com.rentamaquina.maquinaria.app.services.ReservationService;
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
import reports.CountClient;
import reports.StatusReservation;

/**
 *
 * @author jandr
 */
@RestController
@RequestMapping("Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
    
    @Autowired
    private ReservationService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param reservation
     * @return 
     */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public Reservation save(@RequestBody Reservation reservation){
        return service.save(reservation);
    }
    
    /**
     * PUT
     * @param reservation
     * @return 
     */
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public Reservation update(@RequestBody Reservation reservation){
        return service.update(reservation);
    }
    
    /**
     * DELETE
     * @param reservationId
     * @return 
     */
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED) //Anotacion que retorna el status
    public boolean delete(@PathVariable("id")int reservationId){
        return service.deleteReservation(reservationId);
    }
    
    @GetMapping("/report-status")
    public StatusReservation getReservas(){
        return service.getReporteStatusReservaciones();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){
        return service.getReportesTiempoReservaciones(dateOne, dateTwo);
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getClientes(){
        return service.serviceTopClient();
    }
}