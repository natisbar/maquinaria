/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Reservation;
import com.rentamaquina.maquinaria.app.repositories.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reports.CountClient;
import reports.StatusReservation;

/**
 *
 * @author jandr
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository repository;

    /**
     * GET
     *
     * @return
     */
    public List<Reservation> getAll() {
        return repository.getAll();
    }

    /**
     * Buscar por ID
     *
     * @param reservationId
     * @return
     */
    public Optional<Reservation> getReservation(int reservationId) {
        return repository.getReservation(reservationId);
    }

    /**
     * POST
     *
     * @param reservation
     * @return
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return repository.save(reservation);
        } else {
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if (resultado.isPresent()) {
                return reservation;
            } else {
                return repository.save(reservation);
            }
        }
    }

    /**
     * UPDATE
     *
     * @param reservation
     * @return
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> resultado = repository.getReservation(reservation.getIdReservation());
            if (resultado.isPresent()) {
                if (reservation.getStatus()!= null) {
                    resultado.get().setStatus(reservation.getStatus());
                }                
                if (reservation.getDevolutionDate()!= null) {
                    resultado.get().setDevolutionDate(reservation.getDevolutionDate());
                }                
                if (reservation.getStartDate()!= null) {
                    resultado.get().setStartDate(reservation.getStartDate());
                }                                
                repository.save(resultado.get());
                return resultado.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * DELETE
     *
     * @param reservationId
     * @return
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            repository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public StatusReservation getReporteStatusReservaciones() {
        List<Reservation> completed = repository.ReservationStatus("completed");
        List<Reservation> cancelled = repository.ReservationStatus("cancelled");
        return new StatusReservation(completed.size(), cancelled.size());
    }
    
    public List<Reservation> getReportesTiempoReservaciones(String datoA, String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();

        try {
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (datoUno.before(datoDos)) {
            return repository.ReservationTime(datoUno, datoDos);
        } else {
            return new ArrayList<>();
        }
    }
//    
//    public List<CountClient> serviceTopClient() {
//        return repository.getTopClient();
//    }
}