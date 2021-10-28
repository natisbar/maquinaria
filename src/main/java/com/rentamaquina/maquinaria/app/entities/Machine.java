/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jandr
 */

//La libreria lombok me permite usar las siguiente declaraciones 
//para no tener que crear constructores y getters y setters
@Data  //trae getters y setters
@AllArgsConstructor  //Constructor con todos los argumentos
@NoArgsConstructor   //Constructor vacio
@Entity
@Table (name="Machine")
public class Machine implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  //genera automáticamente el ID
    private Integer id;
    @Column(length=50)  //50 numero máximo de caracteres para name
    private String name;
    private String brand;
    private Integer year;
//    @Column(name="category") //indica que en la tabla se llama así, y me permite cambiar el nombre en java
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("machines")
    private Category category;
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="machine")
    @JsonIgnoreProperties({"machine","client"})
    private List<Message> messages;
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="machine")
    @JsonIgnoreProperties({"machine","messages"})
    private List<Reservation> reservations;
    
}
