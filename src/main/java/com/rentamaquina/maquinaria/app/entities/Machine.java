/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private int id;
    private String brand;
    private int model;
    @Column(name="category_id") //indica que en la tabla se llama así, y me permite cambiar el nombre en java
    private int categoryId;
    @Column(length=50)  //50 numero máximo de caracteres para name
    private String name;
    
}
